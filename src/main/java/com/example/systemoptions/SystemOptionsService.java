package com.example.systemoptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemOptionsService {
    private static final Logger logger = LoggerFactory.getLogger(SystemOptionsService.class);

    public void initializeOptions(SystemOptions options) throws SystemOptionsException {
        if (options == null) {
            logger.error("SystemOptions object is null");
            throw new SystemOptionsException("SystemOptions cannot be null");
        }

        try {
            options.validate();
            setupOptions(options);
            logger.info("System options initialized successfully");
        } catch (ValidationException e) {
            logger.error("Validation failed: {}", e.getMessage());
            throw new SystemOptionsException("Validation failed: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An error occurred during initialization: {}", e.getMessage());
            throw new SystemOptionsException("An error occurred during initialization", e);
        }
    }

    private void setupOptions(SystemOptions options) {
        // Implement the necessary setup logic based on validated options
    }
}