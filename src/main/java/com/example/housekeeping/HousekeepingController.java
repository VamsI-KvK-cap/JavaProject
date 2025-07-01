package com.example.housekeeping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.Valid;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
public class HousekeepingController {

    private final HousekeepingService housekeepingService;
    private static final Logger logger = LoggerFactory.getLogger(HousekeepingController.class);

    @Autowired
    public HousekeepingController(HousekeepingService housekeepingService) {
        this.housekeepingService = housekeepingService;
    }

    @PostMapping("/housekeeping")
    public ResponseEntity<String> performHousekeeping(@RequestParam @Valid String operation) {
        try {
            housekeepingService.performHousekeeping(operation);
            logger.info("Housekeeping performed successfully for operation: {}", operation);
            return ResponseEntity.ok("Housekeeping performed successfully for operation: " + operation);
        } catch (SpecificException1 e) {
            logger.error("Specific error occurred: {}", e.getMessage());
            return ResponseEntity.status(400).body("Specific error: " + e.getMessage());
        } catch (SpecificException2 e) {
            logger.error("Another specific error occurred: {}", e.getMessage());
            return ResponseEntity.status(500).body("Another specific error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: {}", e.getMessage());
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Unhandled exception: {}", e.getMessage());
        return ResponseEntity.status(500).body("An unhandled error occurred: " + e.getMessage());
    }
}