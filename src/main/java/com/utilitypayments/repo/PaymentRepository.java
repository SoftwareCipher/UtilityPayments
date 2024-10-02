package com.utilitypayments.repo;

import com.utilitypayments.models.Payment;
import com.utilitypayments.models.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStatus(PaymentStatus status);
}
