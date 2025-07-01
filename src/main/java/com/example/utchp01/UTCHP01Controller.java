package com.example.utchp01;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UTCHP01Controller {

    @PostMapping("/utchp01")
    public UTCHP01Response processUTCHP01(@RequestBody UTCHP01Request request) {
        validateRequest(request);
        UTCHP01Response response = new UTCHP01Response();
        // Business logic to process the request
        // Example: Call to service layer to handle the request
        // response = service.processRequest(request);
        response.setStatus("Success");
        response.setMessage("Request processed successfully");
        return response;
    }

    private void validateRequest(UTCHP01Request request) {
        if (request.getAction() == null || request.getAction().isEmpty()) {
            throw new UTCHP01Exception("UTCHP01-ACTION is required");
        }
        if (request.getStatus() == null || request.getStatus().isEmpty()) {
            throw new UTCHP01Exception("UTCHP01-STATUS is required");
        }
    }

    @ExceptionHandler(UTCHP01Exception.class)
    public ResponseEntity<String> handleUTCHP01Exception(UTCHP01Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}