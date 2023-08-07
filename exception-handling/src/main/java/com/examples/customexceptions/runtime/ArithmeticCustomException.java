package com.examples.customexceptions.runtime;

public class ArithmeticCustomException extends RuntimeException {
    public ArithmeticCustomException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
