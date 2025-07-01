package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class Application {

    @Autowired
    private ReclaimController reclaimController;

    public static void main(String[] args) {
        try {
            ApplicationContext context = SpringApplication.run(Application.class, args);
            Application app = context.getBean(Application.class);
            app.startReclaimProcessing();
        } catch (Exception e) {
            System.err.println("Application startup failed: " + e.getMessage());
            System.exit(1);
        }
    }

    private void startReclaimProcessing() {
        if (reclaimController != null) {
            reclaimController.startReclaimProcessing();
        } else {
            System.err.println("ReclaimController bean is not available.");
        }
    }
}