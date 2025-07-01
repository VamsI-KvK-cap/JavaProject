package com.example.claims;

import java.util.HashMap;
import java.util.Map;

public class ClaimRepository {
    private Map<String, Claim> storage = new HashMap<>();

    public void saveClaim(Claim claim) {
        if (claim == null || claim.getId() == null) {
            throw new IllegalArgumentException("Claim or Claim ID cannot be null");
        }
        storage.put(claim.getId(), claim);
    }

    public Claim getClaimById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Claim ID cannot be null");
        }
        return storage.get(id);
    }

    public void deleteClaim(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Claim ID cannot be null");
        }
        if (!storage.containsKey(id)) {
            throw new IllegalArgumentException("Claim not found");
        }
        storage.remove(id);
    }
}