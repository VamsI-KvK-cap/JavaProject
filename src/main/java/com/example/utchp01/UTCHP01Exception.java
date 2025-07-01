package com.example.utchp01;

public class UTCHP01Exception extends RuntimeException {
    public UTCHP01Exception(String message) {
        super(message);
    }

    public UTCHP01Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public String getUserFriendlyMessage() {
        return "An error occurred during UTCHP01 processing: " + getLocalizedMessage();
    }
}