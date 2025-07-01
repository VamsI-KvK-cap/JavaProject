package com.example.claims;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemOptions {
    private boolean optionFlag;
    private String configuration;

    public void initialize() {
        try {
            Process process = Runtime.getRuntime().exec("IOCHP01L1R");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the output from the external program
                if (line.contains("someCondition")) {
                    optionFlag = true;
                }
                configuration = line; // Example of setting configuration
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isOptionFlag() {
        return optionFlag;
    }

    public String getConfiguration() {
        return configuration;
    }
}