package com.utilitypayments.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAddressRepository extends JpaRepository<PaymentAddressRepository, Long> {
}
