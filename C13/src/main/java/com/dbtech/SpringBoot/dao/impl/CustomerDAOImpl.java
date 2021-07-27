package com.dbtech.SpringBoot.dao.impl;

import com.dbtech.SpringBoot.dao.Customer;
import com.dbtech.SpringBoot.dao.CustomerDAO;
import com.dbtech.SpringBoot.dao.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @PersistenceContext
    EntityManager em;

    @Autowired
    JdbcTemplate jdbcTemplate;
    // to be removed

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = this.jdbcTemplate.query("SELECT * from customers", new CustomerRowMapper());
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {

        Customer c = this.jdbcTemplate.queryForObject("SELECT * FROM customers WHERE id=" + id, new CustomerRowMapper());
        return c;
    }

    @Override
    @Transactional
    public Boolean insertCustomers(Customer customer) {
        em.persist(customer);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateCustomer(Customer customer) {
        Customer dbCustomer = em.find(Customer.class, customer.id);
        dbCustomer.firstName = customer.firstName;
        dbCustomer.lastName = customer.lastName;
        em.persist(dbCustomer);
        return true;
    }

    @Override
    public Boolean deleteCustomerById(int id) {
        String sqlQery = "DELETE FROM `db_tech_school`.`customers`\n" +
                "WHERE id =?;\n";
        int num = this.jdbcTemplate.update(sqlQery, id);
        if (num > 0) {
            return true;
        }
        return false;
    }
}
