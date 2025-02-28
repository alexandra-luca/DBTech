package com.dbtech.SpringBoot.dao;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getAllCustomers();
    public Customer getCustomerById(int id);
    public Boolean insertCustomers(Customer c);
    //    public Boolean updateCustomerById(int id, Customer c);
    public Boolean updateCustomer(Customer c);
    public Boolean deleteCustomerById(int id);
}
