package com.utilitypayments.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pattern_payment")
public class PatternPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namePattern;

    private String iban;

    private String infoAboutPattern;

    @ManyToOne
    @JoinColumn(name = "payment_address_id")
    private PaymentAddressEntity paymentAddress;
}