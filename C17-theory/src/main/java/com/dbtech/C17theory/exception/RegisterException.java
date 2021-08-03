package com.dbtech.C17theory.exception;

public class RegisterException extends RuntimeException {
    public RegisterException(String message) {
        super(message);
    }

    public RegisterException(String message, Throwable ex) {
        super(message, ex);
    }
}
