package com.example.claims;

public class Claim {
    private String claimId;
    private String transactionType;
    private Double amount;
    private String status;
    private String otherRelevantDetails;

    public Claim(String claimId, String transactionType, Double amount, String status, String otherRelevantDetails) {
        this.claimId = claimId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.status = status;
        this.otherRelevantDetails = otherRelevantDetails;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOtherRelevantDetails() {
        return otherRelevantDetails;
    }

    public void setOtherRelevantDetails(String otherRelevantDetails) {
        this.otherRelevantDetails = otherRelevantDetails;
    }
}