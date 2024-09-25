package com.utilitypayments.repo;

import com.utilitypayments.models.PaymentAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAddressRepository extends JpaRepository<PaymentAddressEntity, Long> {
}
