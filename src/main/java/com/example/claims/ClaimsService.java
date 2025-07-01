package com.example.claims;

import java.util.List;

public class ClaimsService {

    private ClaimsProcessor claimsProcessor;
    private ClaimsRepository claimsRepository;

    public ClaimsService(ClaimsProcessor claimsProcessor, ClaimsRepository claimsRepository) {
        this.claimsProcessor = claimsProcessor;
        this.claimsRepository = claimsRepository;
    }

    public ClaimResponse handleClaim(Claim claim) throws ClaimProcessingException {
        validateClaimData(claim);
        claimsProcessor.processClaim(claim);
        return new ClaimResponse(ClaimStatus.PROCESSED, null);
    }

    public ClaimResult handleClaimProcessing(ClaimRequest request) throws ClaimProcessingException {
        Claim claim = claimsRepository.retrieveClaim(request.getClaimId());
        validateClaimData(claim);
        evaluateClaim(claim);
        claimsRepository.storeClaim(claim);
        return new ClaimResult(ClaimStatus.PROCESSED, null);
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
}