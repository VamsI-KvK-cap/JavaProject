package com.example.claims;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClaimsController {

    @PostMapping("/processClaims")
    public ResponseEntity<String> processClaims(@Valid @RequestBody List<Claim> claims) {
        if (claims == null || claims.isEmpty()) {
            return new ResponseEntity<>("Claims list cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
        try {
            for (Claim claim : claims) {
                if (!isValidClaim(claim)) {
                    return new ResponseEntity<>("Invalid claim: " + claim, HttpStatus.BAD_REQUEST);
                }
                // Process each claim
            }
            return new ResponseEntity<>("Claims processed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing claims", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isValidClaim(Claim claim) {
        // Implement claim validation logic
        return true;
    }
}