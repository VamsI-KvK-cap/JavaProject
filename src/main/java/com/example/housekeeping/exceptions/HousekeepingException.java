package com.example.housekeeping.exceptions;

public class HousekeepingException extends RuntimeException {
    public HousekeepingException(String message) {
        super(message);
    }

    public HousekeepingException(String message, Throwable cause) {
        super(message, cause);
    }

    public HousekeepingException(Throwable cause) {
        super(cause);
    }
}