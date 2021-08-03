package com.dbtech.C17theory.controller;

import com.dbtech.C17theory.exception.GetAllException;
import com.dbtech.C17theory.exception.LoginException;
import com.dbtech.C17theory.exception.RegisterException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public String getAllUsers() {
        throw new GetAllException("Cannot get all users");
    }

    @GetMapping("/register")
    @ApiOperation(value = "Registers users in the application", notes = "Currently throws error")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User registered", response = String.class),
            @ApiResponse(code = 404, message = "User already exists", response = RegisterException.class)
    })
    public String register() {
        throw new RegisterException("Cannot register user");
    }

    @GetMapping("/login")
    public String login() {
        throw new LoginException("Cannot login user");
    }

    @ExceptionHandler(GetAllException.class)
    public ResponseEntity handleError() {
        return new ResponseEntity("Specific stuff", HttpStatus.NOT_IMPLEMENTED);
    }

}
