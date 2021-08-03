package com.dbtech.C17theory.exception;

public class GetAllException extends RuntimeException {
    public GetAllException(String message) {
        super(message);
    }

    public GetAllException(String message, Throwable ex) {
        super(message, ex);
    }

}
