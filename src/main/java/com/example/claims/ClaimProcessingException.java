package com.example.claims;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaimProcessingException extends Exception {
    private static final Logger logger = Logger.getLogger(ClaimProcessingException.class.getName());
    private final String errorCode;

    public ClaimProcessingException(String message) {
        super(message);
        this.errorCode = "UNKNOWN_ERROR";
        logError(message, Level.SEVERE);
    }

    public ClaimProcessingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        logError(message, Level.SEVERE);
    }

    public ClaimProcessingException(String message, String errorCode, Level logLevel) {
        super(message);
        this.errorCode = errorCode;
        logError(message, logLevel);
    }

    public String getErrorCode() {
        return errorCode;
    }

    private void logError(String message, Level logLevel) {
        logger.log(logLevel, message);
    }

    public String getUserFriendlyMessage() {
        switch (errorCode) {
            case "INVALID_CLAIM":
                return "The claim submitted is invalid. Please check the details and try again.";
            case "CLAIM_NOT_FOUND":
                return "The claim you are looking for could not be found.";
            case "PROCESSING_ERROR":
                return "There was an error processing your claim. Please try again later.";
            default:
                return "An error occurred while processing your claim. Please try again later.";
        }
    }
}