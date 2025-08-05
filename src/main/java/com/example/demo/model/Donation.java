package com.example.demo.model;



import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Donation {
    private String id;
    private Donor donor;
    private Payment payment;;
}
