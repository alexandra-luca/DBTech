package com.dbtech.C17theory.controller;

import com.dbtech.C17theory.exception.GetAllException;
import com.dbtech.C17theory.exception.LoginException;
import com.dbtech.C17theory.exception.RegisterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGlobalException() {
        return new ResponseEntity("Something bad happened", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(GetAllException.class)
    public ResponseEntity handleError() {
        return new ResponseEntity("Cannot return all users", HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler({LoginException.class, RegisterException.class})
    public ResponseEntity handleLoginRegisterException() {
        return new ResponseEntity("User params problem", HttpStatus.CONFLICT);
    }

}
