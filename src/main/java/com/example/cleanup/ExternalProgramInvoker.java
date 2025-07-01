package com.example.cleanup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalProgramInvoker {

    public boolean invokeProgram(String programName, SystemOptions options) {
        ProcessBuilder processBuilder = new ProcessBuilder(programName);
        processBuilder.redirectErrorStream(true);
        
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return true;
            } else {
                System.err.println("Error executing program: " + output.toString());
                return false;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            return false;
        }
    }
}