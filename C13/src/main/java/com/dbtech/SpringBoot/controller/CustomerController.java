package com.dbtech.SpringBoot.controller;

import com.dbtech.SpringBoot.dao.Customer;
import com.dbtech.SpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerService customerService;
//    get all values, get by id, insert, update and delete

    @ResponseBody
    @GetMapping("/customers") //TODO return an exception, NOT 500 (BETTER 404)
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return customerList;
    }

    //    @GetMapping("customers-html")
//    public ModelAndView getAllCustomers
    @ResponseBody
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Integer cid) {
        Customer c = customerService.getCustomerById(cid);
        return c;
    }

    @ResponseBody
    @PutMapping("/customers")
    public Boolean insertCustomers(@RequestBody Customer customer) {
        Boolean result = customerService.insertCustomers(customer);
        return result;
    }

    @ResponseBody
    @PutMapping("/customers/{id}")
    public Boolean updateCustomerById(@PathVariable(name = "id") Integer cid, @RequestBody Customer customer) {
        customer.id = cid;
        Boolean result = customerService.updateCustomer(customer);
        return result;
    }

    @ResponseBody
    @DeleteMapping("/customers/{id}")
    public Boolean deleteCustomerById(@PathVariable(name = "id") Integer cid) {
        Boolean result = customerService.deleteCustomerById(cid);
        return result;
    }
}
