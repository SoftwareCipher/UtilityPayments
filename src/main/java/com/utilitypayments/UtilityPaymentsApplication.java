package com.utilitypayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UtilityPaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilityPaymentsApplication.class, args);
    }
}
