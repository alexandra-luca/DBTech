package com.dbtech.cryptoexchange.customer;

import com.dbtech.cryptoexchange.customer.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceContract customerService;

    @PostMapping("/login")
    public Customer login(@RequestBody LoginForm loginForm){
        return customerService.getCustomer(loginForm.getEmail(), loginForm.getPassword());
    }

    @PostMapping("/register")
    public Customer createCustomer(@RequestBody LoginForm loginForm) {
        return customerService.createCustomer(new Customer(loginForm.getEmail(), loginForm.getPassword()));
    }
}
