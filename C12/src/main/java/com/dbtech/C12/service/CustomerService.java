package com.dbtech.C11.service;

import com.dbtech.C11.dao.Customer;
import com.dbtech.C11.dao.CustomerDAO;
import com.dbtech.C11.dao.impl.CustomerDAOImpl;
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

    public Boolean updateCustomerById(int id, Customer c){
        Boolean result = customerDAO.updateCustomerById(id, c);
        return result;
    }

    public Boolean deleteCustomerById(int id){
        Boolean result = customerDAO.deleteCustomerById(id);
        return result;
    }
}
