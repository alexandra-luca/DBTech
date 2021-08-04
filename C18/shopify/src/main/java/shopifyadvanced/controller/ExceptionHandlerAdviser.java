package shopifyadvanced.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerAdviser {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity sqlHandleIntegrityException()
    {
        return new ResponseEntity("cannot delete parent object", HttpStatus.NOT_ACCEPTABLE);
    }
}
