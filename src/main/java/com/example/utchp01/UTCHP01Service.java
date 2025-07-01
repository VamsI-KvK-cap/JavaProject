package com.example.utchp01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UTCHP01Service {
    private static final Logger logger = LoggerFactory.getLogger(UTCHP01Service.class);

    public void executeAction(String action, String status) throws UTCHP01Exception {
        logger.info("Executing action: {}, with status: {}", action, status);
        
        if (action == null || status == null) {
            logger.error("Invalid action or status: action={}, status={}", action, status);
            throw new UTCHP01Exception("Action and status must not be null");
        }

        switch (action) {
            case "START":
                handleStart(status);
                break;
            case "STOP":
                handleStop(status);
                break;
            case "PAUSE":
                handlePause(status);
                break;
            default:
                logger.error("Invalid action: {}", action);
                throw new UTCHP01Exception("Invalid action: " + action);
        }
    }

    private void handleStart(String status) throws UTCHP01Exception {
        if (!"READY".equals(status)) {
            logger.error("Invalid status for START action: {}", status);
            throw new UTCHP01Exception("Invalid status for START action: " + status);
        }
        logger.info("Starting process...");
    }

    private void handleStop(String status) throws UTCHP01Exception {
        if (!"RUNNING".equals(status) && !"PAUSED".equals(status)) {
            logger.error("Invalid status for STOP action: {}", status);
            throw new UTCHP01Exception("Invalid status for STOP action: " + status);
        }
        logger.info("Stopping process...");
    }

    private void handlePause(String status) throws UTCHP01Exception {
        if (!"RUNNING".equals(status)) {
            logger.error("Invalid status for PAUSE action: {}", status);
            throw new UTCHP01Exception("Invalid status for PAUSE action: " + status);
        }
        logger.info("Pausing process...");
    }
}