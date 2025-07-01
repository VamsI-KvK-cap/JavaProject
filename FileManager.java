package com.example.filemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    private BufferedReader reader;
    private String currentLine;

    public void openFile(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public String readNextRecord() throws IOException {
        currentLine = reader.readLine();
        return currentLine;
    }

    public boolean isEndOfFile() throws IOException {
        return currentLine == null;
    }

    public void closeFile() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}