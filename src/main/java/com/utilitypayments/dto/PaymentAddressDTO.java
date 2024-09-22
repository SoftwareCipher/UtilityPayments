package com.utilitypayments.dto;


import com.utilitypayments.models.PaymentAddressEntity;
import com.utilitypayments.models.UserEntity;
import lombok.Data;

@Data
public class PaymentAddressDTO {
    private String address;
    private String userEmail;

    public static PaymentAddressEntity toEntity(PaymentAddressDTO paymentAddressDTO, UserRepository userDto){
        if(paymentAddressDTO == null && userDto == null) return null;
        PaymentAddressEntity paymentAddressEntity = new PaymentAddressEntity();
        paymentAddressEntity.setAddress(paymentAddressDTO.address);
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
