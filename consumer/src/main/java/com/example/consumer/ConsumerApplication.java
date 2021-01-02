package com.example.consumer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;

@SpringBootApplication
public class ConsumerApplication {
	static final Logger logger = LogManager.getLogger(ConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@SqsListener(value = "spring-boot-microservice")
	public void consume(String message) throws UnsupportedOperationException {
		logger.info("Got message: {}", message);
	}
}