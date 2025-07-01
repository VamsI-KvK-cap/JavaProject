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

    public FileStatus() {
        this.statusCode = SUCCESS;
        this.statusMessage = "Operation completed successfully.";
        this.customStatusCodes = new HashMap<>();
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
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
            default:
                this.statusMessage = customStatusCodes.getOrDefault(statusCode, "Unknown status.");
                break;
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
}