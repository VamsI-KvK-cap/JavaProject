package com.example.cleanup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanupService {
    private static final Logger logger = LoggerFactory.getLogger(CleanupService.class);

    public void finalizeOptions(SystemOptions options) throws CleanupException {
        if (options == null) {
            throw new CleanupException("SystemOptions cannot be null");
        }
        try {
            if (options.isCleanupRequired()) {
                logger.info("Starting cleanup process");
                // Perform specific cleanup operations based on options
                if (options.isDeleteTemporaryFiles()) {
                    deleteTemporaryFiles();
                }
                if (options.isClearCache()) {
                    clearCache();
                }
                logger.info("Cleanup process completed successfully");
            } else {
                logger.info("No cleanup required as per the provided options");
            }
        } catch (Exception e) {
            logger.error("Error during cleanup: {}", e.getMessage());
            throw new CleanupException("Cleanup failed: " + e.getMessage(), e);
        }
    }

    private void deleteTemporaryFiles() {
        // Logic to delete temporary files
    }

    private void clearCache() {
        // Logic to clear cache
    }
}