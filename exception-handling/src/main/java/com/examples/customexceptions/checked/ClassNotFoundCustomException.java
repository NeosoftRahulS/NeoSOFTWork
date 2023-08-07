package com.examples.customexceptions.checked;

public class ClassNotFoundCustomException extends Exception {

    public ClassNotFoundCustomException(String errorMessage) {
        super(errorMessage);
    }
}
