package com.utilitypayments.mapper;

import com.utilitypayments.dto.PaymentDTO;
import com.utilitypayments.models.Payment;
import com.utilitypayments.models.PaymentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "patternPaymentEntity.id", target = "patternPaymentId")
    @Mapping(source = "status", target = "status")
    PaymentDTO toPaymentDTO(Payment payment);

    @Mapping(source = "patternPaymentId", target = "patternPaymentEntity.id")
    @Mapping(source = "status", target = "status")
    Payment toPayment(PaymentDTO paymentDTO);

    default String map(PaymentStatus status) {
        return status != null ? status.name() : null;
    }

    default PaymentStatus map(String status) {
        return status != null ? PaymentStatus.valueOf(status) : null;
    }
}
