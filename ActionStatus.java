package com.example;

public class ActionStatus {
    private String action;
    private String status;

    public ActionStatus() {
    }

    public ActionStatus(String action, String status) {
        this.action = action;
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActionSuccessful() {
        return "SUCCESS".equalsIgnoreCase(status);
    }

    public void reset() {
        this.action = null;
        this.status = null;
    }

    public String toString() {
        return "ActionStatus{" +
                "action='" + action + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}