package com.utilitypayments.service;

import com.utilitypayments.dto.PaymentAddressDTO;
import com.utilitypayments.dto.PaymentDTO;
import com.utilitypayments.mapper.PaymentAddressMapper;
import com.utilitypayments.mapper.PaymentMapper;
import com.utilitypayments.repo.PaymentAddressRepository;
import com.utilitypayments.repo.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository,
                          PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toPaymentDTO)
                .collect(Collectors.toList());
    }

    // Дополнительные методы
}