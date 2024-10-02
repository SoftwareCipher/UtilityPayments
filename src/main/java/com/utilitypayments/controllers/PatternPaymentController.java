package com.utilitypayments.controllers;

import com.utilitypayments.dto.PatternPaymentDTO;
import com.utilitypayments.service.PatternPaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pattern")
public class PatternPaymentController {
    private final PatternPaymentService patternPaymentService;

    public PatternPaymentController(PatternPaymentService patternPaymentService) {
        this.patternPaymentService = patternPaymentService;
    }

    @PostMapping("/create")
    public PatternPaymentDTO createPattern(@RequestBody PatternPaymentDTO patternPaymentDTO){
        return patternPaymentService.createPattern(patternPaymentDTO);
    }
}
