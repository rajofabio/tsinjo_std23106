package com.example.demo.model;



import lombok.*;


import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    private String id;
    private String pspPaymentId; // ID du paiement Orange Money
    private Instant date;
    private int amount; // en centimes
    private String paymentMethod;
    private String verificationStatus;
}
