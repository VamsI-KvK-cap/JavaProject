package com.example.housekeeping;

import java.util.logging.Logger;

public class HousekeepingService {
    private static final Logger logger = Logger.getLogger(HousekeepingService.class.getName());
    private boolean temporaryDataCleared;
    private boolean flagsReset;

    public HousekeepingService() {
        this.temporaryDataCleared = false;
        this.flagsReset = false;
    }

    public void executeHousekeepingTasks() {
        if (isEnvironmentClean()) {
            clearTemporaryData();
            resetFlags();
            logger.info("Housekeeping tasks executed successfully.");
        } else {
            logger.warning("Environment is not clean. Housekeeping tasks skipped.");
        }
    }

    private boolean isEnvironmentClean() {
        return !temporaryDataCleared && !flagsReset;
    }

    private void clearTemporaryData() {
        // Logic to clear temporary data
        temporaryDataCleared = true;
        logger.info("Temporary data cleared.");
    }

    private void resetFlags() {
        // Logic to reset flags
        flagsReset = true;
        logger.info("Flags reset.");
    }

    public boolean isTemporaryDataCleared() {
        return temporaryDataCleared;
    }

    public boolean areFlagsReset() {
        return flagsReset;
    }
}