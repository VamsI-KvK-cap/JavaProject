package com.example.processing;

public class ProcessingException extends Exception {
    private final String errorCode;

    public ProcessingException(String message) {
        super(message);
        this.errorCode = null;
    }

    public ProcessingException(String errorCode) {
        super("Error with code: " + errorCode);
        this.errorCode = errorCode;
    }

    public ProcessingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return super.getMessage();
    }

    public void logError() {
        System.err.println("Error Code: " + errorCode + ", Message: " + getErrorMessage());
    }
}