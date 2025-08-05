package com.example.demo.service;

import com.example.demo.model.Payment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class VolaService {
    private static final String VOLA_API_URL = "https://42cwka3n4ifcp7ufheyrpmph240iuaxo.lambda-url.eu-west-3.on.aws";
    private static final String API_KEY = "13e46640-889f-4d59-b45b-62f4e9dd3830";

    private final RestTemplate restTemplate;

    public VolaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(String payerEmail, String pspPaymentId, int amount) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = String.format("%s/payment?apiKey=%s&payerEmail=%s&pspType=ORANGE_MONEY&pspPaymentId=%s",
                VOLA_API_URL, API_KEY, payerEmail, pspPaymentId);

        ResponseEntity<Payment> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(headers),
                Payment.class
        );

        return response.getBody();
    }

    public Payment getPaymentStatus(String pspPaymentId, String payerEmail) {
        String url = String.format("%s/payment?apiKey=%s&payerEmail=%s&pspType=ORANGE_MONEY&pspPaymentId=%s",
                VOLA_API_URL, API_KEY, payerEmail, pspPaymentId);

        return restTemplate.getForObject(url, Payment.class);
    }

    public String ping() {
        return restTemplate.getForObject(VOLA_API_URL + "/ping", String.class);
    }
}