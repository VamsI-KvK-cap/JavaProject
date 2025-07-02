package com.example.claims;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class SystemOptions {
    private boolean optionFlag;
    private String configuration;
    private String effectiveMonth;
    private String serviceMonth;
    private boolean programAbortionStatus;

    public void initialize() {
        try {
            Process process = Runtime.getRuntime().exec("IOCHP01L1R");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("someCondition")) {
                    optionFlag = true;
                }
                configuration = line;
            }
            process.waitFor();
            validateOutput(configuration);
        } catch (IOException | InterruptedException e) {
            handleError(e);
        }
    }

    public void finalizeOptions() {
        saveChanges();
    }

    public boolean isOptionFlag() {
        return optionFlag;
    }

    public String getConfiguration() {
        return configuration;
    }

    public String getEffectiveMonth() {
        return effectiveMonth;
    }

    public void setEffectiveMonth(String effectiveMonth) {
        this.effectiveMonth = effectiveMonth;
    }

    public String getServiceMonth() {
        return serviceMonth;
    }

    public void setServiceMonth(String serviceMonth) {
        this.serviceMonth = serviceMonth;
    }

    public boolean isProgramAbortionStatus() {
        return programAbortionStatus;
    }

    public void setProgramAbortionStatus(boolean programAbortionStatus) {
        this.programAbortionStatus = programAbortionStatus;
    }

    private void validateOutput(String output) throws IllegalArgumentException {
        if (output == null || output.isEmpty()) {
            throw new IllegalArgumentException("Invalid output from external program");
        }
    }

    private void handleError(Exception e) {
        e.printStackTrace();
    }

    private void saveChanges() {
        // Implementation for saving changes to configuration
    }
}