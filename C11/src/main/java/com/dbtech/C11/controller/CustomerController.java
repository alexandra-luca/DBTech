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

    @GetMapping("/customers/{id}")  //TODO return an exception, NOT 500(BETTER 404)
    @ResponseBody
    public Customer getCustomerById(@PathVariable(name = "id") Integer cid) {
        Customer customer = this.jdbcTemplate.queryForObject("SELECT * FROM customers WHERE id="+cid,new CustomerRowMapper());
        return customer;
    }


    @PutMapping("/customers")
    @ResponseBody
    public Boolean insertIntoCustomer(@RequestBody Customer customer){
        String sqlQuery = "INSERT INTO `db_tech_school`.`customers`\n" +
                "(`username`,\n" +
                "`last_name`,\n" +
                "`first_name`,\n" +
                "`phone`,\n" +
                "`address`,\n" +
                "`city`,\n" +
                "`postal_code`,\n" +
                "`country`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?\n" +
                ");";

        int n =this.jdbcTemplate.update(sqlQuery,customer.getUsername(),customer.getLastName(),
                customer.getFirstName(),customer.getPhone(),customer.getAddress(),customer.getCity(),
                customer.getPostalCode(),customer.getCountry());

        if (n >0) {
            return true;
        } else {
            return false;
        }
    }
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
