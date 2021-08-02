package com.dbtech.Spring_jpa.controller;

import com.dbtech.Spring_jpa.dao.Customer;
import com.dbtech.Spring_jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ResponseBody
    @GetMapping("/customers-html")
    public ModelAndView getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomers();
        ModelAndView view = new ModelAndView("customers.html");
        view.addObject("customersList", customerList);
        return view;
    }

    @ResponseBody
    @GetMapping("/customers/{id}")
    public ModelAndView getCustomerbyId(@PathVariable(name = "id")Integer cid){
        Customer customer = customerService.getCustomerById(cid);
        ModelAndView  view = new ModelAndView("customer.html");
        view.addObject("customer", customer);
        return view;
    }

    @PutMapping("/customers")
    @ResponseBody
    public Boolean insertIntoCustomer(@RequestBody Customer customer){
        Boolean result = customerService.insertCustomer( customer);
        return result;
    }

    @ResponseBody
    @PutMapping("/customers/{id}")
    public Boolean updateCustomerById(@PathVariable( name = "id") Integer cid, @RequestBody Customer customer){

        customer.id = cid;
        Boolean result = customerService.updateCustomerById( customer);
        return result;
    }

    @ResponseBody
    @DeleteMapping("/customers/{id}")
    public Boolean deleteCustomerById(@PathVariable( name = "id") Integer cid){
        Boolean result = customerService.deleteCustomerById(cid);
        return result;
    }

}
