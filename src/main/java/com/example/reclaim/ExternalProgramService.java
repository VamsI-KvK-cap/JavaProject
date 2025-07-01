package com.example.reclaim;

import java.io.IOException;

public class ExternalProgramService {

    public void initializeSystemOptions() throws IOException {
        // Call external program for initializing system options
        ProcessBuilder processBuilder = new ProcessBuilder("externalProgramInitialize");
        processBuilder.start();
    }

    public void processActions() throws IOException {
        // Call external program for processing actions
        ProcessBuilder processBuilder = new ProcessBuilder("externalProgramProcessActions");
        processBuilder.start();
    }

    public void finalizeSystemOptions() throws IOException {
        // Call external program for finalizing system options
        ProcessBuilder processBuilder = new ProcessBuilder("externalProgramFinalize");
        processBuilder.start();
    }

    public void processClaims() throws IOException {
        // Call external program for processing claims
        ProcessBuilder processBuilder = new ProcessBuilder("externalProgramProcessClaims");
        processBuilder.start();
    }
}