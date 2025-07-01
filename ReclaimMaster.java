package com.example.reclaim;

import java.util.Objects;

public class ReclaimMaster {
    private String reclaimId;
    private String claimantName;
    private String claimDate;
    private double claimAmount;
    private String status;

    public ReclaimMaster(String reclaimId, String claimantName, String claimDate, double claimAmount) {
        this.reclaimId = reclaimId;
        this.claimantName = claimantName;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.status = "Pending";
    }

    public String getReclaimId() {
        return reclaimId;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void approveReclaim() {
        this.status = "Approved";
    }

    public void rejectReclaim() {
        this.status = "Rejected";
    }

    public void initializeReclaim(String reclaimId, String claimantName, String claimDate, double claimAmount) {
        this.reclaimId = reclaimId;
        this.claimantName = claimantName;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.status = "Pending";
    }

    public boolean validateReclaim() {
        if (reclaimId == null || reclaimId.isEmpty()) {
            throw new IllegalArgumentException("Reclaim ID cannot be null or empty");
        }
        if (claimantName == null || claimantName.isEmpty()) {
            throw new IllegalArgumentException("Claimant name cannot be null or empty");
        }
        if (claimDate == null || claimDate.isEmpty()) {
            throw new IllegalArgumentException("Claim date cannot be null or empty");
        }
        if (claimAmount <= 0) {
            throw new IllegalArgumentException("Claim amount must be greater than zero");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReclaimMaster)) return false;
        ReclaimMaster that = (ReclaimMaster) o;
        return Double.compare(that.claimAmount, claimAmount) == 0 &&
               Objects.equals(reclaimId, that.reclaimId) &&
               Objects.equals(claimantName, that.claimantName) &&
               Objects.equals(claimDate, that.claimDate) &&
               Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reclaimId, claimantName, claimDate, claimAmount, status);
    }
}