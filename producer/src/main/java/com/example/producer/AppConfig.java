package com.example.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("sqs-queue-name")
    String getProducerQueue() {
        return "spring-boot-microservice";
    }
}
