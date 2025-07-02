package com.example.claims;

public class ClaimsException extends Exception {
    public ClaimsException(String message) {
        super(message);
    }

    public ClaimsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClaimsException(Throwable cause) {
        super(cause);
    }
}