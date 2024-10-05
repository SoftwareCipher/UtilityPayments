package com.utilitypayments.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI paymentAppOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Payment Application API")
                        .description("API документация для платежного приложения")
                        .version("1.0.0"));
    }
}
