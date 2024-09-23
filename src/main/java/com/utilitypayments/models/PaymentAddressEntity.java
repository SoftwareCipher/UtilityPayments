package com.utilitypayments.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_address")
public class PaymentAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_entity", referencedColumnName = "id")
    private UserEntity user;
}
