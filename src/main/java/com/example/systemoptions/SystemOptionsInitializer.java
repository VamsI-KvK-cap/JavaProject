package com.example.systemoptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemOptionsInitializer {
    private static final Logger logger = LoggerFactory.getLogger(SystemOptionsInitializer.class);

    public static void main(String[] args) {
        String configFilePath = args.length > 0 ? args[0] : "default-config.properties";
        Properties properties = new Properties();
        
        try (FileInputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
            String systemOption = properties.getProperty("CHP01-SYSTEM-OPTIONS");
            SystemOptionsService systemOptionsService = new SystemOptionsService();
            systemOptionsService.initializeOptions(systemOption);
        } catch (IOException e) {
            logger.error("IO error during system options initialization", e);
        } catch (NullPointerException e) {
            logger.error("Required system option not found in configuration", e);
        } catch (Exception e) {
            logger.error("Error during system options initialization", e);
        }
    }
}