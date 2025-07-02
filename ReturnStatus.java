package com.example.status;

public class ReturnStatus {
    private int normalOperationStatus;
    private int invalidCommandStatus;
    private int failureToCloseFileStatus;
    private int inputOutputFailureStatus;

    public int getNormalOperationStatus() {
        return normalOperationStatus;
    }

    public void setNormalOperationStatus(int normalOperationStatus) {
        this.normalOperationStatus = normalOperationStatus;
    }

    public int getInvalidCommandStatus() {
        return invalidCommandStatus;
    }

    public void setInvalidCommandStatus(int invalidCommandStatus) {
        this.invalidCommandStatus = invalidCommandStatus;
    }

    public int getFailureToCloseFileStatus() {
        return failureToCloseFileStatus;
    }

    public void setFailureToCloseFileStatus(int failureToCloseFileStatus) {
        this.failureToCloseFileStatus = failureToCloseFileStatus;
    }

    public int getInputOutputFailureStatus() {
        return inputOutputFailureStatus;
    }

    public void setInputOutputFailureStatus(int inputOutputFailureStatus) {
        this.inputOutputFailureStatus = inputOutputFailureStatus;
    }
}