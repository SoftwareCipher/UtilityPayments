package com.utilitypayments.controllers;

import com.utilitypayments.dto.PaymentAddressDTO;
import com.utilitypayments.service.PaymentAddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payAddress")
public class PaymentAddressController {
    private final PaymentAddressService paymentAddressService;

    public PaymentAddressController(PaymentAddressService paymentAddressService) {
        this.paymentAddressService = paymentAddressService;
    }

    @PostMapping("/create")
    public PaymentAddressDTO createPaymentAddress(@RequestBody PaymentAddressDTO paymentAddressDTO){
        return paymentAddressService.createPaymentAddress(paymentAddressDTO);
    }
}
