package com.example.fileservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    private BufferedReader reader;

    public FileService(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public String readNextRecord() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}