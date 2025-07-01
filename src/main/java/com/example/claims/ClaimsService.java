package com.example.claims;

import java.util.List;

public class ClaimsService {

    public void processVoluntaryClaim(Claim claim) throws ClaimProcessingException {
        validateClaimData(claim);
        if (isVoluntary(claim)) {
            evaluateClaim(claim);
            updateClaimStatus(claim, ClaimStatus.PROCESSED);
        } else {
            throw new ClaimProcessingException("Claim is not voluntary.");
        }
    }

    public void processEstimateClaim(Claim claim) throws ClaimProcessingException {
        validateClaimData(claim);
        if (isEstimate(claim)) {
            evaluateClaim(claim);
            updateClaimStatus(claim, ClaimStatus.PROCESSED);
        } else {
            throw new ClaimProcessingException("Claim is not an estimate.");
        }
    }

    private void validateClaimData(Claim claim) throws ClaimProcessingException {
        if (claim == null || claim.getAmount() <= 0) {
            throw new ClaimProcessingException("Invalid claim data.");
        }
    }

    private void evaluateClaim(Claim claim) throws ClaimProcessingException {
        if (claim.getAmount() > 10000) {
            throw new ClaimProcessingException("Claim amount exceeds limit.");
        }
        // Additional evaluation logic can be added here
    }

    private void updateClaimStatus(Claim claim, ClaimStatus status) {
        claim.setStatus(status);
    }

    private boolean isVoluntary(Claim claim) {
        return claim.getType() == ClaimType.VOLUNTARY;
    }

    private boolean isEstimate(Claim claim) {
        return claim.getType() == ClaimType.ESTIMATE;
    }
}