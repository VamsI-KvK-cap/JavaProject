package com.example.claims;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClaimsProcessorTest {

    @InjectMocks
    private ClaimsProcessor claimsProcessor;

    @Mock
    private ClaimRepository claimRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessValidVoluntaryClaim() {
        Claim claim = new Claim("voluntary", 1000);
        when(claimRepository.save(claim)).thenReturn(claim);
        
        Claim result = claimsProcessor.processClaim(claim);
        
        assertNotNull(result);
        assertEquals("processed", result.getStatus());
        verify(claimRepository).save(claim);
    }

    @Test
    void testProcessValidEstimateClaim() {
        Claim claim = new Claim("estimate", 500);
        when(claimRepository.save(claim)).thenReturn(claim);
        
        Claim result = claimsProcessor.processClaim(claim);
        
        assertNotNull(result);
        assertEquals("processed", result.getStatus());
        verify(claimRepository).save(claim);
    }

    @Test
    void testProcessInvalidClaim() {
        Claim claim = new Claim("invalid", -100);
        
        assertThrows(IllegalArgumentException.class, () -> claimsProcessor.processClaim(claim));
    }

    @Test
    void testHandleErrorDuringClaimProcessing() {
        Claim claim = new Claim("voluntary", 1000);
        when(claimRepository.save(claim)).thenThrow(new RuntimeException("Database error"));
        
        assertThrows(RuntimeException.class, () -> claimsProcessor.processClaim(claim));
    }

    @Test
    void testStatusUpdateAfterProcessingClaim() {
        Claim claim = new Claim("voluntary", 1000);
        when(claimRepository.save(claim)).thenReturn(claim);
        
        claimsProcessor.processClaim(claim);
        
        assertEquals("processed", claim.getStatus());
    }
}