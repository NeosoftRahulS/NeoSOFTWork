package com.examples.customexceptions.checked;

public class SQLCustomException extends Exception {
    public SQLCustomException(String errorMessage) {
        super(errorMessage);
    }
}
