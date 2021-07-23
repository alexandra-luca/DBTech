package com.dbtech.cryptoexchange.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceContract {

    @Autowired
    private JdbcTemplate template;

    public Customer createCustomer(Customer customer){
        template.update("INSERT INTO customer(email, password) values (?, ?)", customer.getEmail(),
                customer.getPassword());
        return customer;
    }

    public Customer getCustomer(String email, String password){
        Customer customer = template.queryForObject("SELECT * FROM customer WHERE email = " + email +
                " AND password = " + password, new CustomerMapper());
        return customer;
    }

}
