package com.utilitypayments.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDTO {
    private Long id;
    private String cardNumber;
    private BigDecimal amount;
    private String status;
    private LocalDateTime creationDateTime;
    private LocalDateTime statusChangeDateTime;
    private Long patternPaymentId;
}
