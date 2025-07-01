package com.example.fileoperations;

import java.util.HashMap;
import java.util.Map;

public class FileStatus {
    private String statusCode;
    private String statusMessage;
    private Map<String, String> customStatusCodes;

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    public static final String PENDING = "PENDING";
    public static final String NOT_FOUND = "NOT_FOUND";
    public static final String ACCESS_DENIED = "ACCESS_DENIED";

    public FileStatus() {
        this.statusCode = SUCCESS;
        this.statusMessage = "Operation completed successfully.";
        this.customStatusCodes = new HashMap<>();
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        if (isValidStatusCode(statusCode)) {
            this.statusCode = statusCode;
            switch (statusCode) {
                case SUCCESS:
                    this.statusMessage = "Operation completed successfully.";
                    break;
                case ERROR:
                    this.statusMessage = "An error occurred during the operation.";
                    break;
                case PENDING:
                    this.statusMessage = "The operation is pending.";
                    break;
                case NOT_FOUND:
                    this.statusMessage = "The requested file was not found.";
                    break;
                case ACCESS_DENIED:
                    this.statusMessage = "Access to the file is denied.";
                    break;
                default:
                    this.statusMessage = customStatusCodes.getOrDefault(statusCode, "Unknown status.");
                    break;
            }
        } else {
            throw new IllegalArgumentException("Invalid status code.");
        }
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void addCustomStatusCode(String code, String message) {
        customStatusCodes.put(code, message);
    }

    public void clearStatusCodes() {
        this.statusCode = SUCCESS;
        this.statusMessage = "Operation completed successfully.";
        customStatusCodes.clear();
    }

    private boolean isValidStatusCode(String statusCode) {
        return statusCode.equals(SUCCESS) || statusCode.equals(ERROR) || 
               statusCode.equals(PENDING) || statusCode.equals(NOT_FOUND) || 
               statusCode.equals(ACCESS_DENIED) || customStatusCodes.containsKey(statusCode);
    }
}