package com.example.errorhandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandler {
    private static final Logger logger = Logger.getLogger(ErrorHandler.class.getName());

    public void handleError(Exception e) {
        logError(e);
        if (isCriticalError(e)) {
            abortProgram();
        } else {
            handleNonCriticalError(e);
        }
    }

    private void logError(Exception e) {
        logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
    }

    private boolean isCriticalError(Exception e) {
        return e instanceof NullPointerException || e instanceof OutOfMemoryError;
    }

    private void abortProgram() {
        cleanup();
        System.exit(1);
    }

    private void cleanup() {
        // Release resources, close connections, etc.
        logger.log(Level.INFO, "Cleaning up resources before program abortion.");
    }

    private void handleNonCriticalError(Exception e) {
        logger.log(Level.WARNING, "Non-critical error occurred: " + e.getMessage(), e);
    }

    public void throwCustomException(String message) throws CustomException {
        throw new CustomException(message);
    }

    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }
}