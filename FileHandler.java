package com.example.filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private BufferedReader reader;
    private FileWriter writer;
    private String currentLine;

    public FileHandler(String filePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
        this.writer = new FileWriter(filePath, true);
    }

    public String readNextRecord() throws IOException {
        currentLine = reader.readLine();
        return currentLine;
    }

    public boolean isEndOfFile() throws IOException {
        return currentLine == null;
    }

    public void writeRecord(String record) throws IOException {
        writer.write(record + System.lineSeparator());
        writer.flush();
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
        if (writer != null) {
            writer.close();
        }
    }
}