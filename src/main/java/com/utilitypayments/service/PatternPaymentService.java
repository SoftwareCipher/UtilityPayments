package com.utilitypayments.service;

import com.utilitypayments.dto.PatternPaymentDTO;
import com.utilitypayments.mapper.PatternPaymentMapper;
import com.utilitypayments.repo.PatternPaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PatternPaymentService {

    private final PatternPaymentRepository patternPaymentRepository;
    private final PatternPaymentMapper patternPaymentMapper;

    public PatternPaymentService(PatternPaymentRepository patternPaymentRepository,
                                 PatternPaymentMapper patternPaymentMapper) {
        this.patternPaymentRepository = patternPaymentRepository;
        this.patternPaymentMapper = patternPaymentMapper;
    }

    public PatternPaymentDTO createPattern(PatternPaymentDTO patternPaymentDTO) {
        return null;
    }
}
