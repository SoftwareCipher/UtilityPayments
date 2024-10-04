package com.utilitypayments.service;

import com.utilitypayments.dto.PaymentDTO;
import com.utilitypayments.mapper.PaymentMapper;
import com.utilitypayments.models.Payment;
import com.utilitypayments.models.PaymentStatus;
import com.utilitypayments.repo.PaymentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final PaymentStatusSimulator paymentStatusSimulator;

    public PaymentService(PaymentRepository paymentRepository,
                          PaymentMapper paymentMapper, PaymentStatusSimulator paymentStatusSimulator) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.paymentStatusSimulator = paymentStatusSimulator;
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toPaymentDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO createPayment(PaymentDTO paymentDTO){
        Payment payment = paymentMapper.toPayment(paymentDTO);
        payment.setStatus(PaymentStatus.NEW);
        payment.setCreationDateTime(LocalDateTime.now());
        return paymentMapper.toPaymentDTO(paymentRepository.save(payment));
    }

    @Scheduled(fixedRate = 1000)
    public void UpdatePaymentStatues(){
        List<Payment> newPayments = paymentRepository.findByStatus(PaymentStatus.NEW);
        for (Payment payment : newPayments) {
            PaymentStatus newStatus = paymentStatusSimulator.getPaymentStatus(payment);
            if (newStatus != PaymentStatus.NEW) {
                payment.setStatus(newStatus);
                payment.setStatusChangeDateTime(LocalDateTime.now());
                paymentRepository.save(payment);
            }
        }
    }
}