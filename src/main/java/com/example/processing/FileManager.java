package com.example.processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<BufferedReader> openedFiles;

    public FileManager() {
        openedFiles = new ArrayList<>();
    }

    public void openFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        openedFiles.add(reader);
    }

    public String readNextRecord() throws IOException {
        for (BufferedReader reader : openedFiles) {
            String record = reader.readLine();
            if (record != null) {
                return record;
            }
        }
        return null;
    }

    public void closeAllFiles() throws IOException {
        for (BufferedReader reader : openedFiles) {
            reader.close();
        }
        openedFiles.clear();
    }
}