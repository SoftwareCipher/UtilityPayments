package com.utilitypayments.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pattern_payment")
public class PatternPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePattern;
    private String Iban;
    private String infoAboutPattern;
    @ManyToOne
    @JoinColumn(name = "user_entity", referencedColumnName = "id")
    private UserEntity user;
}
