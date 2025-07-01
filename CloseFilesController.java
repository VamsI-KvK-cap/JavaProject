package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.service.CloseFilesService;
import com.example.service.HousekeepingService;
import com.example.model.CloseFilesRequest;
import com.example.model.CloseFilesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class CloseFilesController {

    private static final Logger logger = LoggerFactory.getLogger(CloseFilesController.class);

    @Autowired
    private CloseFilesService closeFilesService;

    @Autowired
    private HousekeepingService housekeepingService;

    @PostMapping("/9900-CLOSE-FILES")
    public ResponseEntity<CloseFilesResponse> closeFiles(@RequestBody CloseFilesRequest request) {
        logger.info("Received request to close files: {}", request);
        validateRequest(request);
        CloseFilesResponse response = null;
        try {
            response = closeFilesService.closeFiles(request);
            if (response == null) {
                logger.error("CloseFilesService returned null response");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            housekeepingService.performHousekeeping();
            logger.info("Housekeeping performed successfully");
        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            logger.error("Error closing files: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        logger.info("Response for close files request: {}", response);
        return ResponseEntity.ok(response);
    }

    private void validateRequest(CloseFilesRequest request) {
        if (request == null || request.getFileIds() == null || request.getFileIds().isEmpty()) {
            throw new IllegalArgumentException("Invalid request: fileIds must not be null or empty");
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationExceptions(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}