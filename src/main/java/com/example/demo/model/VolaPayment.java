package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class VolaPayment {
    private String id;
    private String verificationStatus;
    private PspPayment pspPayment;


    public static class PspPayment {
        private String id;
        private int amount;


    }
}