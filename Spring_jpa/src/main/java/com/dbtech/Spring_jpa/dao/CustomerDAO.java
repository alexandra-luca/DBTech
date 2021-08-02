package com.dbtech.Spring_jpa.dao;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getAllCustomers();
    public Customer getCustomerById(int id);
    public Boolean insertCustomer(Customer customer);
    public Boolean updateCustomerById ( Customer customer);
    public Boolean deleteCustomerById(int id);

    public Customer getCustomerByEmailAndPassword(String email, String password);
}
