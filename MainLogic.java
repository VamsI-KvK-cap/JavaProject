package com.example.mainlogic;

import com.example.service.ExternalProgramService;
import com.example.service.ProcessingService;

public class MainLogic {
    private boolean chp01AbortedInPgm = false;
    private boolean errorFlag = false;
    private ExternalProgramService externalProgramService;
    private ProcessingService processingService;
    private int effectiveMonth;
    private int serviceMonth;
    private boolean endOfFile = false;

    public MainLogic(ExternalProgramService externalProgramService, ProcessingService processingService, int effectiveMonth, int serviceMonth) {
        this.externalProgramService = externalProgramService;
        this.processingService = processingService;
        this.effectiveMonth = effectiveMonth;
        this.serviceMonth = serviceMonth;
    }

    public void execute() {
        initializeSystemOptions();
        if (chp01AbortedInPgm) {
            return;
        }
        processRecords();
        finalizeSystemOptions();
    }

    private void initializeSystemOptions() {
        chp01AbortedInPgm = externalProgramService.executeIOCHP01L1R();
    }

    private void processRecords() {
        while (!endOfFileReached()) {
            if (shouldProcessRecord()) {
                try {
                    processingService.processRecord();
                } catch (Exception e) {
                    errorFlag = true;
                }
            }
            housekeepingTasks();
        }
    }

    private boolean endOfFileReached() {
        return endOfFile; // Logic to determine if the end of the file is reached
    }

    private boolean shouldProcessRecord() {
        // Logic to determine if the record should be processed based on effective and service months
        return effectiveMonth == serviceMonth; // Example condition
    }

    private void housekeepingTasks() {
        // Perform housekeeping tasks
    }

    private void finalizeSystemOptions() {
        externalProgramService.executeIOCHP01L1U();
        if (errorFlag) {
            // Handle error flag
        }
    }
}