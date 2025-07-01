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
        // Business logic to process the request
        UTCHP01Response response = new UTCHP01Response();
        // Populate response based on request processing
        response.setStatus("Success");
        response.setMessage("Request processed successfully");
        return response;
    }

    @ExceptionHandler(UTCHP01Exception.class)
    public ResponseEntity<String> handleUTCHP01Exception(UTCHP01Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}