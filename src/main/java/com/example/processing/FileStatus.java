package com.example.processing;

public class FileStatus {
    public static final int FILE_NOT_FOUND = 404;
    public static final int FILE_READ_SUCCESS = 200;
    public static final int FILE_WRITE_SUCCESS = 201;
    public static final int FILE_ACCESS_DENIED = 403;
    public static final int FILE_ALREADY_EXISTS = 409;

    private int statusCode;

    public FileStatus() {
        this.statusCode = FILE_NOT_FOUND;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isFileNotFound() {
        return statusCode == FILE_NOT_FOUND;
    }

    public boolean isFileReadSuccess() {
        return statusCode == FILE_READ_SUCCESS;
    }

    public boolean isFileWriteSuccess() {
        return statusCode == FILE_WRITE_SUCCESS;
    }

    public boolean isFileAccessDenied() {
        return statusCode == FILE_ACCESS_DENIED;
    }

    public boolean isFileAlreadyExists() {
        return statusCode == FILE_ALREADY_EXISTS;
    }

    public void resetStatusCode() {
        this.statusCode = FILE_NOT_FOUND;
    }
}