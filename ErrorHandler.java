package com.example.errorhandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandler {
    private static final Logger logger = Logger.getLogger(ErrorHandler.class.getName());

    public void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public void logError(Exception e) {
        logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
    }

    public void handleError(Exception e) {
        logError(e);
        if (isCriticalError(e)) {
            abortProgram();
        } else {
            handleNonCriticalError(e);
        }
    }

    private boolean isCriticalError(Exception e) {
        return e instanceof NullPointerException || e instanceof OutOfMemoryError;
    }

    private void abortProgram() {
        cleanup();
        logCriticalError("Program is aborting due to a critical error.");
        System.exit(1);
    }

    private void cleanup() {
        logger.log(Level.INFO, "Cleaning up resources before program abortion.");
    }

    private void handleNonCriticalError(Exception e) {
        logger.log(Level.WARNING, "Non-critical error occurred: " + e.getMessage(), e);
    }

    public void throwCustomException(String message) throws CustomException {
        logCustomException(message);
        throw new CustomException(message);
    }

    private void logCustomException(String message) {
        logger.log(Level.SEVERE, "Custom exception thrown: " + message);
    }

    private void logCriticalError(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }
}