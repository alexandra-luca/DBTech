package com.dbtech.Spring_jpa.dao.impl;

import com.dbtech.Spring_jpa.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    EntityManager entityManager ;



    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers  = entityManager.createQuery("SELECT c from Customer c", Customer.class).getResultList();
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Transactional
    @Override
    public Boolean insertCustomer(Customer customer) {
        entityManager.persist(customer);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateCustomerById( Customer customer) {

        Customer customer1 = entityManager.find(Customer.class, customer.id);
        customer1.username = customer.username;
        customer1.firstName = customer.firstName;
        customer1.lastName = customer.lastName;
        customer1.phone = customer.phone;
        customer1.address = customer.address;
        customer1.city = customer.city;
        customer1.postalCode = customer.postalCode;
        customer1.country = customer.country;
        entityManager.persist(customer1);
        return true;

    }

    @Override
    @Transactional
    public Boolean deleteCustomerById(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
        return true;
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String password) {
        return null;
    }


}
