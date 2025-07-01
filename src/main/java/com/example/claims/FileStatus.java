package com.example.claims;

public class FileStatus {
    public static final int FILE_NOT_FOUND = 404;
    public static final int FILE_READ_SUCCESS = 200;
    public static final int FILE_WRITE_SUCCESS = 201;
    public static final int FILE_ACCESS_DENIED = 403;
    public static final int FILE_ALREADY_EXISTS = 409;
    
    public static boolean isFileNotFound(int statusCode) {
        return statusCode == FILE_NOT_FOUND;
    }

    public static boolean isFileReadSuccess(int statusCode) {
        return statusCode == FILE_READ_SUCCESS;
    }

    public static boolean isFileWriteSuccess(int statusCode) {
        return statusCode == FILE_WRITE_SUCCESS;
    }

    public static boolean isFileAccessDenied(int statusCode) {
        return statusCode == FILE_ACCESS_DENIED;
    }

    public static boolean isFileAlreadyExists(int statusCode) {
        return statusCode == FILE_ALREADY_EXISTS;
    }
}