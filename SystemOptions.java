package com.example.systemoptions;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class SystemOptions {
    private String CHP01_SYSTEM_OPTIONS;
    private String CHP01_ABORTED_IN_PGM;
    private String CHP01_SYSTEM_OPTIONS_ALT;

    public String getCHP01_SYSTEM_OPTIONS() {
        return CHP01_SYSTEM_OPTIONS;
    }

    public void setCHP01_SYSTEM_OPTIONS(String CHP01_SYSTEM_OPTIONS) {
        if (CHP01_SYSTEM_OPTIONS != null && !CHP01_SYSTEM_OPTIONS.isEmpty()) {
            this.CHP01_SYSTEM_OPTIONS = CHP01_SYSTEM_OPTIONS;
        } else {
            throw new IllegalArgumentException("Invalid value for CHP01_SYSTEM_OPTIONS");
        }
    }

    public String getCHP01_ABORTED_IN_PGM() {
        return CHP01_ABORTED_IN_PGM;
    }

    public void setCHP01_ABORTED_IN_PGM(String CHP01_ABORTED_IN_PGM) {
        if (CHP01_ABORTED_IN_PGM != null && !CHP01_ABORTED_IN_PGM.isEmpty()) {
            this.CHP01_ABORTED_IN_PGM = CHP01_ABORTED_IN_PGM;
        } else {
            throw new IllegalArgumentException("Invalid value for CHP01_ABORTED_IN_PGM");
        }
    }

    public String getCHP01_SYSTEM_OPTIONS_ALT() {
        return CHP01_SYSTEM_OPTIONS_ALT;
    }

    public void setCHP01_SYSTEM_OPTIONS_ALT(String CHP01_SYSTEM_OPTIONS_ALT) {
        if (CHP01_SYSTEM_OPTIONS_ALT != null && !CHP01_SYSTEM_OPTIONS_ALT.isEmpty()) {
            this.CHP01_SYSTEM_OPTIONS_ALT = CHP01_SYSTEM_OPTIONS_ALT;
        } else {
            throw new IllegalArgumentException("Invalid value for CHP01_SYSTEM_OPTIONS_ALT");
        }
    }

    public void initializeOptions(String CHP01_SYSTEM_OPTIONS, String CHP01_ABORTED_IN_PGM, String CHP01_SYSTEM_OPTIONS_ALT) {
        setCHP01_SYSTEM_OPTIONS(CHP01_SYSTEM_OPTIONS);
        setCHP01_ABORTED_IN_PGM(CHP01_ABORTED_IN_PGM);
        setCHP01_SYSTEM_OPTIONS_ALT(CHP01_SYSTEM_OPTIONS_ALT);
    }

    public void loadConfiguration(String filePath) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (input == null) {
                throw new IOException("Unable to find configuration file: " + filePath);
            }
            properties.load(input);
            setCHP01_SYSTEM_OPTIONS(properties.getProperty("CHP01_SYSTEM_OPTIONS"));
            setCHP01_ABORTED_IN_PGM(properties.getProperty("CHP01_ABORTED_IN_PGM"));
            setCHP01_SYSTEM_OPTIONS_ALT(properties.getProperty("CHP01_SYSTEM_OPTIONS_ALT"));
        }
    }

    public void validateOptions() {
        if (CHP01_SYSTEM_OPTIONS == null || CHP01_SYSTEM_OPTIONS.isEmpty()) {
            throw new IllegalStateException("CHP01_SYSTEM_OPTIONS must be set");
        }
        if (CHP01_ABORTED_IN_PGM == null || CHP01_ABORTED_IN_PGM.isEmpty()) {
            throw new IllegalStateException("CHP01_ABORTED_IN_PGM must be set");
        }
        if (CHP01_SYSTEM_OPTIONS_ALT == null || CHP01_SYSTEM_OPTIONS_ALT.isEmpty()) {
            throw new IllegalStateException("CHP01_SYSTEM_OPTIONS_ALT must be set");
        }
    }
}