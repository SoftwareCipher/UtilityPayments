package com.utilitypayments.service;

import com.utilitypayments.dto.PatternPaymentDTO;
import com.utilitypayments.mapper.PatternPaymentMapper;
import com.utilitypayments.mapper.PaymentAddressMapper;
import com.utilitypayments.models.PatternPaymentEntity;
import com.utilitypayments.models.PaymentAddressEntity;
import com.utilitypayments.repo.PatternPaymentRepository;
import com.utilitypayments.repo.PaymentAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class PatternPaymentService {

    private final PatternPaymentRepository patternPaymentRepository;
    private final PatternPaymentMapper patternPaymentMapper;
    private final PaymentAddressRepository paymentAddressRepository;

    public PatternPaymentService(PatternPaymentRepository patternPaymentRepository,
                                 PatternPaymentMapper patternPaymentMapper, PaymentAddressRepository paymentAddressRepository) {
        this.patternPaymentRepository = patternPaymentRepository;
        this.patternPaymentMapper = patternPaymentMapper;
        this.paymentAddressRepository = paymentAddressRepository;
    }

    public PatternPaymentDTO createPattern(PatternPaymentDTO patternPaymentDTO) {
        PatternPaymentEntity entity = patternPaymentMapper.toEntity(patternPaymentDTO);
        PaymentAddressEntity paymentAddressEntity = paymentAddressRepository.findById(
                patternPaymentDTO.getUserPaymentAddressId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        entity.setPaymentAddress(paymentAddressEntity);
        return patternPaymentMapper.toDTO(patternPaymentRepository.save(entity));
    }
}
