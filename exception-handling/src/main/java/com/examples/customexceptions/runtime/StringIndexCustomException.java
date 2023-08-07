package com.examples.customexceptions.runtime;

public class StringIndexCustomException extends RuntimeException {

    public StringIndexCustomException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
