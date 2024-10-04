package com.utilitypayments.service;

import com.utilitypayments.models.Payment;
import com.utilitypayments.models.PaymentStatus;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class PaymentStatusSimulator {
    private final Random random = new Random();

    public PaymentStatus getPaymentStatus(Payment payment) {
        Duration duration = Duration.between(payment.getCreationDateTime(), LocalDateTime.now());
        long secondsElapsed = duration.getSeconds();

        if (secondsElapsed < 2) {
            return PaymentStatus.NEW;
        } else {
            PaymentStatus[] statuses = PaymentStatus.values();
            return statuses[random.nextInt(statuses.length)];
        }
    }
}
