package com.dbtech.C11.controller;

import com.dbtech.C11.dao.Customer;
import com.dbtech.C11.dao.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    JdbcTemplate jdbcTemplate;
//    get all values, get by id, insert, update and delete

    @ResponseBody
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        // conectare la baza de date
        // SELECT * from customers
        // ResultSet while(next())

        List<Customer> customers = this.jdbcTemplate.query("SELECT * from customers", new CustomerRowMapper());
        return customers;
    }

//    @GetMapping("/customers/{id}")
//    public Customer getCustomerById(@PathVariable(name = "id") Integer cid) {
//
//    }
//
//    @PutMapping("/customers")
//    public Customer insertCustomers(@RequestBody Customer customer) {
//
//    }
//
//    @PutMapping("/customers/{id}")
//    public Customer updateCustomerById(@PathVariable(name = "id") Integer cid, @RequestBody Customer customer) {
//
//    }
//
//    @DeleteMapping("/customers/{id}")
//    public Customer deleteCustomerById(@PathVariable(name = "id") Integer cid) {
//
//    }

}
