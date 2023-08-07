package com.examples.customexceptions.checked;

public class FileNotFoundCustomException extends Exception {
    public FileNotFoundCustomException(String errorMessage) {
        super(errorMessage);
    }
}
