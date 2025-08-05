package com.example.demo.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Help {
  private String id;
  private Beneficiary beneficiary;
  private Payment payment;
  private String accidentDescription;
}
