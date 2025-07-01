package com.example.cleanup;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/IOCHP01L1U")
public class CleanupController {

    private final CleanupService cleanupService;

    public CleanupController(CleanupService cleanupService) {
        this.cleanupService = cleanupService;
    }

    @PostMapping("/finalize")
    public ResponseEntity<String> finalizeSystemOptions(@RequestBody FinalizeRequest request) {
        try {
            cleanupService.finalizeSystemOptions(request);
            return ResponseEntity.ok("System options finalized successfully.");
        } catch (CleanupException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @ExceptionHandler(CleanupException.class)
    public ResponseEntity<String> handleCleanupException(CleanupException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}