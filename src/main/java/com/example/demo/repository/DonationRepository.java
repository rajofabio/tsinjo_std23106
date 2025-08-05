package com.example.demo.repository;// src/main/java/com/hei/tsinjo/repository/DonationRepository.java

import com.example.demo.model.Donation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DonationRepository {
    private final List<Donation> donations = new ArrayList<>();
    private int idCounter = 1;

    public Donation save(Donation donation) {
        donation.setId("don-" + idCounter++);
        donations.add(donation);
        return donation;
    }

    public List<Donation> findAllByOrderByPaymentDateDesc() {
        return donations.stream()
                .sorted(Comparator.comparing(d -> d.getPayment().getDate(), Comparator.reverseOrder()))
                .toList();
    }
}