package com.utilitypayments.models;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private int phoneNumber;
}
