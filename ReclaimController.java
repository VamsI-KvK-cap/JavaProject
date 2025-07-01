package com.example.reclaim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class ReclaimApplication {

    private static final Logger logger = LoggerFactory.getLogger(ReclaimApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReclaimApplication.class, args);
    }

    @Bean
    public ReclaimService reclaimService() {
        return new ReclaimService();
    }

    @ExceptionHandler(Exception.class)
    public void handleError(Exception e) {
        logger.error("An error occurred: {}", e.getMessage());
    }
}