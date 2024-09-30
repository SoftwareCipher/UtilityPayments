package com.utilitypayments.mapper;

import com.utilitypayments.dto.PaymentAddressDTO;
import com.utilitypayments.models.PaymentAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentAddressMapper {
    @Mapping(source = "userEntity.id", target = "userId")
    PaymentAddressDTO toDTO(PaymentAddressEntity address);

    @Mapping(source = "userId", target = "userEntity.id")
    PaymentAddressEntity toEntity(PaymentAddressDTO addressDTO);
}
