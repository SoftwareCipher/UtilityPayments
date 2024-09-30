package com.utilitypayments.dto;

import lombok.Data;

@Data
public class PatternPaymentDTO {
    private Long id;
    private String templateName;
    private String iban;
    private String paymentPurpose;
    private Long userPaymentAddressId;
}
