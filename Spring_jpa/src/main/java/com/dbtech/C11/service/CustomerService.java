package com.dbtech.C11.service;

import com.dbtech.C11.dao.Customer;
import com.dbtech.C11.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = customerDAO.getAllCustomers();
        return customerList;
    }


    public Customer getCustomerById(int id){
       // Customer c = customerDAO.getCustomerById(id);
        Customer c2 = repository.findById(id).get();
        return c2;
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
    public List<Customer> customersFiltered(String username, String city, String country){
        List<Customer> customerList = customerDAO.customersFiltered(username, city, country);
        return customerList;
    }

    public Customer getByPhone ( String phone){
        Customer customer = repository.findByPhone(phone);
        return customer;
    }

    public List<Customer> streetType ( String street){
        List<Customer> customerList = repository.searchByStreetType(street);
        return  customerList;
    }

    public List<Customer> searchByLastNameLength ( int lengthLastName){
        List<Customer> customerList = repository.searchByLastNameLength(lengthLastName);
        return customerList;
    }


}
