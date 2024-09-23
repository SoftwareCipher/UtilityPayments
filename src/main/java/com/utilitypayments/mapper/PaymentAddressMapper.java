package com.utilitypayments.mapper;

import com.utilitypayments.dto.PaymentAddressDTO;
import com.utilitypayments.models.PaymentAddressEntity;
import com.utilitypayments.models.UserEntity;
import com.utilitypayments.repo.UserRepository;

public class PaymentAddressMapper {
    public static PaymentAddressEntity toEntity(PaymentAddressDTO paymentAddressDTO, UserRepository userRepository){
        if(paymentAddressDTO == null && userRepository == null) return null;
        PaymentAddressEntity paymentAddressEntity = new PaymentAddressEntity();
        paymentAddressEntity.setAddress(paymentAddressDTO.getAddress());
        UserEntity user = userRepository.findByEmail(paymentAddressDTO.getUserEmail());
        if (user == null) {
            throw new RuntimeException("User not found with email: " + paymentAddressDTO.getUserEmail());
        }
        paymentAddressEntity.setUser(user);
        return paymentAddressEntity;
    }

    public static PaymentAddressDTO toDto(PaymentAddressEntity entity){
        if(entity == null) return null;

        PaymentAddressDTO paymentAddressDTO = new PaymentAddressDTO();
        paymentAddressDTO.setAddress(entity.getAddress());
        if(entity.getUser() != null){
            paymentAddressDTO.setUserEmail(entity.getUser().getEmail());
        }
        return paymentAddressDTO;
    }
}
