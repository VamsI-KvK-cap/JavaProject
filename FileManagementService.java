package com.example.filemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManagementService {
    private BufferedReader reader;
    private String currentLine;

    public FileManagementService(String filePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    public String readNextRecord() throws IOException {
        currentLine = reader.readLine();
        return currentLine;
    }

    public boolean isEndOfFile() throws IOException {
        return currentLine == null;
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public void processFile() {
        try {
            while (!isEndOfFile()) {
                String record = readNextRecord();
                // Process the record
            }
        } catch (IOException e) {
            // Handle exception
        } finally {
            try {
                close();
            } catch (IOException e) {
                // Handle exception
            }
        }
    }
}