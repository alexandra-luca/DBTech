package com.dbtech.C17theory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot login user - no username")
public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable ex) {
        super(message, ex);
    }
}
