package com.dbtech.C11.dao;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getAllCustomers();
    public Customer getCustomerById(int id);
    public Boolean insertCustomer(Customer customer);
    public Boolean updateCustomerById ( Customer customer);
    public Boolean deleteCustomerById(int id);
    public List<Customer> customersFiltered(String username, String city, String country);

}
