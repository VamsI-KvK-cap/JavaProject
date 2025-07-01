package com.example.claims;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClaimsController {

    private final ClaimsService claimsService;
    private final ClaimsProcessor claimsProcessor;

    public ClaimsController(ClaimsService claimsService, ClaimsProcessor claimsProcessor) {
        this.claimsService = claimsService;
        this.claimsProcessor = claimsProcessor;
    }

    @PostMapping("/processClaim")
    public ResponseEntity<String> processClaimRequest(@Valid @RequestBody Claim claim) {
        if (!isValidClaim(claim)) {
            return new ResponseEntity<>("Invalid claim: " + claim, HttpStatus.BAD_REQUEST);
        }
        try {
            claimsService.handleClaim(claim);
            return new ResponseEntity<>("Claim processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing claim", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/processClaimRequest")
    public ResponseEntity<String> processClaimRequest(@Valid @RequestBody ClaimRequest request) {
        if (!isValidClaimRequest(request)) {
            return new ResponseEntity<>("Invalid claim request: " + request, HttpStatus.BAD_REQUEST);
        }
        try {
            claimsProcessor.processClaim(request);
            return new ResponseEntity<>("Claim request processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing claim request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isValidClaim(Claim claim) {
        // Implement claim validation logic
        return claim != null && claim.getId() != null && claim.getAmount() > 0;
    }

    private boolean isValidClaimRequest(ClaimRequest request) {
        // Implement claim request validation logic
        return request != null && request.getClaimId() != null && request.getDetails() != null;
    }
}