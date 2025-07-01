package com.example.exceptions;

public class ApplicationException extends Exception {
    private String errorCode;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}