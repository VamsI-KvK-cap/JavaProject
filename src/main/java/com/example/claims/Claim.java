package com.example.claims;

public class Claim {
    private String id;
    private String type;
    private Double amount;
    private String status;
    private String data;
    private String otherDetails;

    public Claim(String id, String type, Double amount, String status, String data, String otherDetails) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.data = data;
        this.otherDetails = otherDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}