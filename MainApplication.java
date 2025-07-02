package com.example.application;

import com.example.service.CloseFilesService;

public class MainApplication {
    public static void main(String[] args) {
        CloseFilesService closeFilesService = new CloseFilesService();
        try {
            closeFilesService.closeFiles(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}