package com.example.housekeeping;

public class Main {
    public static void main(String[] args) {
        try {
            HousekeepingService housekeepingService = new HousekeepingService();
            housekeepingService.initializeSystemOptions();
            housekeepingService.checkForAbortion();
            housekeepingService.determineDataRetrieval();
            housekeepingService.performHousekeepingTasks();
            housekeepingService.closeFiles();
            
            ProcessingLoop processingLoop = new ProcessingLoop();
            processingLoop.executeProcessingLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}