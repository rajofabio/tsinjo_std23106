package com.example.demo.model;

import java.time.Instant;
import lombok.*;

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
