package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TsinjoService {
    private final Map<String, Donation> donationsStorage = new ConcurrentHashMap<>();
    private final VolaService volaService;

    public TsinjoService(VolaService volaService) {
        this.volaService = volaService;
    }

    public Donation createDonation(String email, String fullName, int amount, String pspPaymentId) {
        Payment volaPayment = volaService.createPayment(email, pspPaymentId, amount);

        Donor donor = new Donor(UUID.randomUUID().toString(), email, fullName);
        Payment payment = new Payment(
                        volaPayment.getId(),
                        pspPaymentId,
                Instant.now(),
                amount,
                        "ORANGE_MONEY",
                        volaPayment.getVerificationStatus()
                );

        Donation donation = new Donation(UUID.randomUUID().toString(), donor, payment);
        donationsStorage.put(donation.getId(), donation);
        return donation;
    }

    @Scheduled(fixedRate = 30000)
    public void verifyPendingPayments() {
        donationsStorage.values().stream()
                .filter(d -> "VERIFYING".equals(d.getPayment().getVerificationStatus()))
                .forEach(donation -> {
                    Payment updatedPayment = volaService.getPaymentStatus(
                            donation.getPayment().getPspPaymentId(),
                            donation.getDonor().getEmail()
                    );
                    donation.getPayment().setVerificationStatus(updatedPayment.getVerificationStatus());
                });
    }

    public List<Donation> getAllDonations() {
        return new ArrayList<>(donationsStorage.values());
    }

    public List<Help> getAllHelps() {
        return Collections.emptyList();
    }

}