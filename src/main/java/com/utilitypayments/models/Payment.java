package com.utilitypayments.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime creationDateTime;

    private LocalDateTime statusChangeDateTime;

    @ManyToOne
    @JoinColumn(name = "patternPayment_id")
    private PatternPaymentEntity patternPaymentEntity;
}