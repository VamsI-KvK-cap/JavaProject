package com.example.exception;

public class HousekeepingException extends Exception {
    public HousekeepingException(String message) {
        super(message);
    }

    public HousekeepingException(String message, Throwable cause) {
        super(message, cause);
    }

    public HousekeepingException(String message, String errorCode) {
        super(message + " Error Code: " + errorCode);
    }

    public HousekeepingException(String message, Throwable cause, String errorCode) {
        super(message + " Error Code: " + errorCode, cause);
    }
}