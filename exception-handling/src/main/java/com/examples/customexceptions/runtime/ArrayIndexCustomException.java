package com.examples.customexceptions.runtime;

public class ArrayIndexCustomException extends RuntimeException {

    public ArrayIndexCustomException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
