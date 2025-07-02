package com.example.claims;

import java.util.List;

public class ClaimsService {
    private List<Claim> reclaimMasterData;

    public void initializeReclaimMasterData(List<Claim> claims) {
        this.reclaimMasterData = claims;
    }

    public List<Claim> readReclaimMasterData() {
        return reclaimMasterData;
    }

    public boolean checkDataIntegrity() {
        for (Claim claim : reclaimMasterData) {
            if (claim.getId() == null || claim.getAmount() < 0) {
                return false;
            }
        }
        return true;
    }

    public List<Claim> detectToleranceFailures(double tolerance) {
        return reclaimMasterData.stream()
                .filter(claim -> claim.getAmount() > tolerance)
                .toList();
    }
}

class Claim {
    private String id;
    private double amount;

    public Claim(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}