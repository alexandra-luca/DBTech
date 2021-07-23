package com.dbtech.cryptoexchange.customer;

public interface CustomerServiceContract {
    public Customer createCustomer(Customer customer);
    public Customer getCustomer(String email, String password);
}
