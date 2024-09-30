package com.utilitypayments.mapper;

import com.utilitypayments.dto.PatternPaymentDTO;
import com.utilitypayments.models.PatternPaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatternPaymentMapper {

    @Mapping(source = "userPaymentAddress.id", target = "userPaymentAddressId")
    PatternPaymentDTO toDTO(PatternPaymentEntity template);

    @Mapping(source = "userPaymentAddressId", target = "userPaymentAddress.id")
    PatternPaymentEntity toEntity(PatternPaymentDTO templateDTO);
}
