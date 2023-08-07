package com.examples.customexceptions.runtime;

public class NullPointerCustomException extends RuntimeException{

    public NullPointerCustomException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
