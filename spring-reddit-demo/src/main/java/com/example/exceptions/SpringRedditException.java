package com.example.exceptions;

public class SpringRedditException extends RuntimeException {
    public SpringRedditException(String exceptionMessage) {
        super(exceptionMessage);
    }
}