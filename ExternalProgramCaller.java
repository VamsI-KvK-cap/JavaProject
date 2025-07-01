package com.example.externalprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalProgramCaller {

    public String callIOCHP01L1R(String input) throws IOException {
        return executeCommand("IOCHP01L1R", input);
    }

    public String callUTCHP01(String input) throws IOException {
        return executeCommand("UTCHP01", input);
    }

    public String callUTCHPRCLM2(String input) throws IOException {
        return executeCommand("UTCHPRCLM2", input);
    }

    public String callUTCHPRCLM5(String input) throws IOException {
        return executeCommand("UTCHPRCLM5", input);
    }

    private String executeCommand(String command, String input) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command, input);
        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }
        return output.toString().trim();
    }
}