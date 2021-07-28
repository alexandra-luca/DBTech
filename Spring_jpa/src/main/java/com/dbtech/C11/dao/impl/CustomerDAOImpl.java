package com.dbtech.C11.dao.impl;

import com.dbtech.C11.dao.*;
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
    public List<Customer> customersFiltered(String username, String city, String country) {

        String query = "select c from Customer c ";

        if(!username.isEmpty()){
            query += " where username = ?1";
        }

        if(!city.isEmpty()){
            if(!username.isEmpty()){
                query += " and city = ?2";
            }else {
                query += " where city =?1";
            }

        }

        if(!country.isEmpty()){
            if((!username.isEmpty()) && (!city.isEmpty())){
                query += "  and country =?3";
            } else if( (!username.isEmpty()) || (!city.isEmpty())){
                query += "  and country =?2";
            } else{
                query += " where country = ?1";
            }
        }

        TypedQuery sql = entityManager.createQuery(query, Customer.class);
        if(!username.isEmpty() && !city.isEmpty() && !country.isEmpty()){
            sql.setParameter(1, username);
            sql.setParameter(2, city);
            sql.setParameter(3, country);
        } else if (!username.isEmpty() && !city.isEmpty() && country.isEmpty()){
            sql.setParameter(1, username);
            sql.setParameter(2, city);
        } else if (username.isEmpty() && !city.isEmpty() && !country.isEmpty()){
            sql.setParameter(1, city);
            sql.setParameter(2, country);
        } else if (!username.isEmpty() && city.isEmpty() && !country.isEmpty()){
            sql.setParameter(1, username);
            sql.setParameter(2, country);
        } else if (!username.isEmpty() && city.isEmpty() && country.isEmpty()){
            sql.setParameter(1, username);
        } else if (username.isEmpty() && !city.isEmpty() && country.isEmpty()){
            sql.setParameter(1, city);
        }else if (username.isEmpty() && city.isEmpty() && !country.isEmpty()){
            sql.setParameter(1, country);
        }
        return sql.getResultList();
    }


}
