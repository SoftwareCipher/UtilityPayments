package com.utilitypayments.repo;

import com.utilitypayments.models.PatternPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatternPaymentRepository extends JpaRepository<PatternPaymentEntity, Long> {
}
