package com.example.controller;

import com.example.service.ReclaimService;
import com.example.exception.ReclaimException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/reclaim")
public class ReclaimMasterController {

    private final ReclaimService reclaimService;
    private static final Logger logger = LoggerFactory.getLogger(ReclaimMasterController.class);

    @Autowired
    public ReclaimMasterController(ReclaimService reclaimService) {
        this.reclaimService = reclaimService;
    }

    @GetMapping("/master-data")
    public ResponseEntity<?> readReclaimMasterData(@RequestParam String effectiveMonth, @RequestParam String serviceMonth) {
        try {
            reclaimService.initializeOptions();
            if (reclaimService.checkForAbortion()) {
                return ResponseEntity.status(400).body("Abortion condition met: Please verify the input data and try again.");
            }
            return ResponseEntity.ok(reclaimService.processReclaimData(effectiveMonth, serviceMonth));
        } catch (ReclaimException e) {
            logger.error("Error processing reclaim data: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error processing reclaim data: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input parameters: {}", e.getMessage());
            return ResponseEntity.status(400).body("Invalid input parameters: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
            return ResponseEntity.status(500).body("Unexpected error occurred: " + e.getMessage());
        }
    }
}