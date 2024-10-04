package com.utilitypayments.service;

import com.utilitypayments.dto.PaymentAddressDTO;
import com.utilitypayments.mapper.PaymentAddressMapper;
import com.utilitypayments.models.PaymentAddressEntity;
import com.utilitypayments.models.UserEntity;
import com.utilitypayments.repo.PaymentAddressRepository;
import com.utilitypayments.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentAddressService {

    private final PaymentAddressMapper paymentAddressMapper;

    private final PaymentAddressRepository paymentAddressRepository;
    private final UserRepository userRepository;

    public PaymentAddressService(PaymentAddressMapper paymentAddressMapper,
                                 PaymentAddressRepository paymentAddressRepository,
                                 UserRepository userRepository) {
        this.paymentAddressMapper = paymentAddressMapper;
        this.paymentAddressRepository = paymentAddressRepository;
        this.userRepository = userRepository;
    }

    public PaymentAddressDTO createPaymentAddress(PaymentAddressDTO paymentAddressDTO) {
        PaymentAddressEntity entity = paymentAddressMapper.toEntity(paymentAddressDTO);
        UserEntity user = userRepository.findById(paymentAddressDTO.getUserId()).orElseThrow(
                () -> new RuntimeException("User not found"));
        entity.setUserEntity(user);
        return paymentAddressMapper.toDTO(paymentAddressRepository.save(entity));
    }
}
