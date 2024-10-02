package com.utilitypayments.service;

import com.utilitypayments.dto.PaymentAddressDTO;
import com.utilitypayments.mapper.PaymentAddressMapper;
import com.utilitypayments.repo.PaymentAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentAddressService {

    private final PaymentAddressMapper paymentAddressMapper;

    private final PaymentAddressRepository paymentAddressRepository;

    public PaymentAddressService(PaymentAddressMapper paymentAddressMapper,
                                 PaymentAddressRepository paymentAddressRepository) {
        this.paymentAddressMapper = paymentAddressMapper;
        this.paymentAddressRepository = paymentAddressRepository;
    }

    public PaymentAddressDTO createPaymentAddress(PaymentAddressDTO paymentAddressDTO) {
        return null;
    }
}
