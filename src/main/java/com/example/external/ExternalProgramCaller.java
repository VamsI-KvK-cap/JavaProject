package com.example.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExternalProgramCaller {

    public String callIOCHP01L1R(String... params) throws IOException {
        validateParams(params);
        return executeCommand("IOCHP01L1R", params);
    }

    public String callUTCHP01(String... params) throws IOException {
        validateParams(params);
        return executeCommand("UTCHP01", params);
    }

    public String callUTCHPRCLM2(String... params) throws IOException {
        validateParams(params);
        return executeCommand("UTCHPRCLM2", params);
    }

    public String callUTCHPRCLM5(String... params) throws IOException {
        validateParams(params);
        return executeCommand("UTCHPRCLM5", params);
    }

    private String executeCommand(String command, String... params) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(command, params);
        Process process = processBuilder.start();
        
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }
        
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new IOException("Command " + command + " failed with exit code " + exitCode);
        }
        
        return output.toString().trim();
    }

    private void validateParams(String... params) {
        if (params == null || Arrays.stream(params).anyMatch(param -> param == null || param.isEmpty())) {
            throw new IllegalArgumentException("Invalid parameters provided");
        }
    }
}