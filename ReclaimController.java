package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.service.ReclaimService;

@RestController
public class ReclaimController {

    private static final Logger logger = LoggerFactory.getLogger(ReclaimController.class);

    @Autowired
    private ReclaimService reclaimService;

    @GetMapping("/reclaim")
    public ResponseEntity<?> getReclaim(@RequestParam String requestId) {
        try {
            reclaimService.initializeOptions();
            if (reclaimService.checkForAbortion(requestId)) {
                return ResponseEntity.badRequest().body("Reclaim process aborted.");
            }
            var data = reclaimService.retrieveData(requestId);
            var result = reclaimService.processReclaims(data);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error processing reclaim request", e);
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}