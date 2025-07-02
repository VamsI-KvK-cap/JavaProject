package com.example.fileoperations;

public class FileStatus {
    public static final String EOF_STATUS = "EOF";
    public static final String SUCCESS_STATUS = "SUCCESS";
    public static final String NOT_FOUND_STATUS = "NOT_FOUND";

    private String statusCode;
    private boolean endOfFileReached;

    public FileStatus() {
        this.statusCode = SUCCESS_STATUS;
        this.endOfFileReached = false;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        if (isValidStatusCode(statusCode)) {
            this.statusCode = statusCode;
        } else {
            throw new IllegalArgumentException("Invalid status code.");
        }
    }

    public boolean isEndOfFileReached() {
        return endOfFileReached;
    }

    public void setEndOfFileReached(boolean endOfFileReached) {
        this.endOfFileReached = endOfFileReached;
    }

    private boolean isValidStatusCode(String statusCode) {
        return statusCode.equals(SUCCESS_STATUS) || statusCode.equals(EOF_STATUS) || statusCode.equals(NOT_FOUND_STATUS);
    }
}