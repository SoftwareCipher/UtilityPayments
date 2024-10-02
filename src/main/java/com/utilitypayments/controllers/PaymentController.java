package com.utilitypayments.controllers;

import com.utilitypayments.dto.PaymentDTO;
import com.utilitypayments.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pay")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping("/create")
    public PaymentDTO createPayment(@RequestBody PaymentDTO paymentDTO){
        return paymentService.createPayment(paymentDTO);
    }
}
