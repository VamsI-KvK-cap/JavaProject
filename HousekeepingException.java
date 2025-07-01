package com.example.exception;

public class HousekeepingException extends Exception {
    public HousekeepingException(String message) {
        super(message);
    }

    public HousekeepingException(String message, Throwable cause) {
        super(message, cause);
    }
}