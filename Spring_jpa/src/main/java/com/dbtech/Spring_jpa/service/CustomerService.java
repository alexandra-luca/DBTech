package com.dbtech.Spring_jpa.service;

import com.dbtech.Spring_jpa.dao.Customer;
import com.dbtech.Spring_jpa.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = customerDAO.getAllCustomers();
        return customerList;
    }

    public Customer getCustomerById(int id){
        Customer c = customerDAO.getCustomerById(id);
        return c;
    }

    public Boolean insertCustomer(Customer customer){
        Boolean result = customerDAO.insertCustomer(customer);
        return result;
    }

    public Boolean updateCustomerById (Customer customer){
        Boolean result = customerDAO.updateCustomerById(customer);
        return result;
    }

    public Boolean deleteCustomerById(int id){
        Boolean result = customerDAO.deleteCustomerById(id);
        return result;
    }

}
