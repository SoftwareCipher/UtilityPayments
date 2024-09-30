package com.utilitypayments.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "payment_address")
public class PaymentAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "paymentAddress", cascade = CascadeType.ALL)
    private List<PatternPaymentEntity> patternPaymentEntities = new ArrayList<>();
}