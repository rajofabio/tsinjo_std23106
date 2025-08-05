package com.example.demo.repository;

import com.example.demo.model.Payment;
import java.util.Optional;

public interface PaymentRepository {
  void save(Payment payment);

  Optional<Payment> findById(String id);

  void updateStatus(String id, String status);
}
