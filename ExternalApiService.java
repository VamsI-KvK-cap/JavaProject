package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class ExternalApiService {

    private static final Logger logger = LoggerFactory.getLogger(ExternalApiService.class);
    private final RestTemplate restTemplate;

    @Autowired
    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void initializeSystemOptions(String apiUrl) {
        try {
            String response = restTemplate.postForObject(apiUrl + "/initialize", null, String.class);
            logger.info("Initialization response: {}", response);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error during initialization: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error during initialization: {}", e.getMessage());
        }
    }

    public void finalizeSystemOptions(String apiUrl) {
        try {
            String response = restTemplate.postForObject(apiUrl + "/finalize", null, String.class);
            logger.info("Finalization response: {}", response);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error during finalization: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error during finalization: {}", e.getMessage());
        }
    }
}