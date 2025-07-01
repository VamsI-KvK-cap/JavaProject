package com.example.housekeeping.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CHP20ReclaimMaster {
    private String reclaimId;
    private String description;
    private double amount;
    private String status;
    private LocalDate createdDate;
    private LocalDate modifiedDate;

    public String getReclaimId() {
        return reclaimId;
    }

    public void setReclaimId(String reclaimId) {
        if (reclaimId == null || reclaimId.isEmpty()) {
            throw new IllegalArgumentException("Reclaim ID cannot be null or empty");
        }
        this.reclaimId = reclaimId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = LocalDate.parse(createdDate, DateTimeFormatter.ISO_DATE);
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = LocalDate.parse(modifiedDate, DateTimeFormatter.ISO_DATE);
    }

    public void processReclaim() {
        // Business logic for processing the reclaim
        // Implementation details would go here
    }
}