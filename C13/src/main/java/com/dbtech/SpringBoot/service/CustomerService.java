package com.dbtech.SpringBoot.service;

import com.dbtech.SpringBoot.dao.Customer;
import com.dbtech.SpringBoot.dao.CustomerDAO;
import com.dbtech.SpringBoot.dao.impl.CustomerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    // Acelasi lucru ca la Autowired
//    CustomerDAO customerDAO = new CustomerDAOImpl();

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerDAO.getAllCustomers();
        return customerList;
    }

    public Customer getCustomerById(int id) {
        Customer c = customerDAO.getCustomerById(id);
        return c;
    }

    public Boolean insertCustomers(Customer c){
        Boolean result = customerDAO.insertCustomers(c);
        return result;
    }

    public Boolean updateCustomer(Customer c){
        Boolean result = customerDAO.updateCustomer(c);
        return result;
    }

    public Boolean deleteCustomerById(int id){
        Boolean result = customerDAO.deleteCustomerById(id);
        return result;
    }
}
