package com.example.systemoptions.exceptions;

public class SystemOptionsException extends Exception {
    public SystemOptionsException() {
        super();
    }

    public SystemOptionsException(String message) {
        super(message);
    }

    public SystemOptionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemOptionsException(Throwable cause) {
        super(cause);
    }
}