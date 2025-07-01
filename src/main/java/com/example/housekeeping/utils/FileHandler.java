package com.example.housekeeping.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    private BufferedReader reader;
    private String currentLine;
    private static final Logger logger = Logger.getLogger(FileHandler.class.getName());

    public FileHandler(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public String readNextRecord() throws IOException {
        if (reader == null) {
            throw new IOException("File is not open.");
        }
        currentLine = reader.readLine();
        if (currentLine == null) {
            logger.log(Level.INFO, "End of file reached.");
        }
        return currentLine;
    }

    public boolean isEndOfFile() throws IOException {
        if (reader == null) {
            throw new IOException("File is not open.");
        }
        return currentLine == null;
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
            reader = null;
            logger.log(Level.INFO, "File closed successfully.");
        }
    }
}