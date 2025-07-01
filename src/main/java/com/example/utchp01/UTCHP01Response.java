package com.example.utchp01;

public class UTCHP01Response {
    private String message;
    private boolean success;

    public UTCHP01Response() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}