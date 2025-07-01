package com.example.service;

import java.io.Closeable;
import java.io.IOException;

public class CloseFilesService {
    private boolean historicalFlag;
    private boolean currentFlag;

    public CloseFilesService() {
        initializeSystemOptions();
    }

    private void initializeSystemOptions() {
        historicalFlag = false;
        currentFlag = true;
    }

    public boolean checkForProgramAbortion() {
        return Thread.currentThread().isInterrupted();
    }

    public void setHistoricalFlag(boolean historicalFlag) {
        this.historicalFlag = historicalFlag;
    }

    public void setCurrentFlag(boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    public Object retrieveData() {
        if (historicalFlag) {
            return getHistoricalData();
        } else {
            return getCurrentData();
        }
    }

    private Object getHistoricalData() {
        return new Object();
    }

    private Object getCurrentData() {
        return new Object();
    }

    public void closeFiles(Closeable... files) {
        for (Closeable file : files) {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                // Handle exception
                e.printStackTrace();
            }
        }
    }

    public void finalizeSystemOptions() {
        historicalFlag = false;
        currentFlag = false;
    }
}