package com.examples.customexceptions.runtime;

public class NumberFormatCustomException extends RuntimeException {

    public NumberFormatCustomException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
