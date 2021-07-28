package com.dbtech.C11.controller;

import com.dbtech.C11.dao.Customer;
import com.dbtech.C11.service.CustomerRepository;
import com.dbtech.C11.service.CustomerService;
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

    @ResponseBody
    @GetMapping("/filteredCustomers")
    public ModelAndView customersFiltered(@RequestParam(required = false) String username, @RequestParam(required = false) String city, @RequestParam(required = false) String country){

        List<Customer> filteredCustomers = customerService.customersFiltered(username, city, country);
        ModelAndView view = new ModelAndView("filtered_customer.html");
        view.addObject("customersList", filteredCustomers);
        return view;
    }

    @ResponseBody
    @GetMapping("/phone/{phone}")
    public Customer getByPhone ( @PathVariable ( name = "phone") String phone){
        Customer customer = customerService.getByPhone(phone);
        return customer;
    }

    @ResponseBody
    @GetMapping ("/street_type")
    public List<Customer> streetType (@RequestParam ( required = false, name = "street" ) String strada){
        List<Customer> customerList = customerService.streetType(strada);
        return customerList;
    }

    @ResponseBody
    @GetMapping("/length_last_name")
    public List<Customer> lengthLastName(@RequestParam (required = false, name = "min_length") Integer min_length){
        List<Customer> customerList = customerService.searchByLastNameLength(min_length);
        return  customerList;
    }

}
