package com.dbtech.C13.dao.impl;

import com.dbtech.C11.dao.Customer;
import com.dbtech.C11.dao.CustomerDAO;
import com.dbtech.C11.dao.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

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
    public Boolean insertCustomers(Customer customer) {
        String sqlQuery = "INSERT INTO `db_tech_school`.`customers`\n" +
                "(`username`,\n" +
                "`last_name`,\n" +
                "`first_name`,\n" +
                "`phone`,\n" +
                "`address`,\n" +
                "`city`,\n" +
                "`postal_code`,\n" +
                "`country`)\n" +
                "VALUES\n" +
                "(?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?);\n";
        int n = jdbcTemplate.update(sqlQuery,
                customer.getUsername(),
                customer.getLastName(),
                customer.getFirstName(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPostalCode(),
                customer.getCountry());
        if (n > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateCustomerById(int id, Customer customer) {
        String sqlQuery = "UPDATE `db_tech_school`.`customers`\n" +
                "SET\n" +
                "`username` = ?,\n" +
                "`last_name` = ?,\n" +
                "`first_name` = ?,\n" +
                "`phone` = ?,\n" +
                "`address` = ?,\n" +
                "`city` = ?,\n" +
                "`postal_code` = ?,\n" +
                "`country` = ?\n" +
                "WHERE `id` = ?;";
        int num = this.jdbcTemplate.update(sqlQuery,
                customer.getUsername(),
                customer.getLastName(),
                customer.getFirstName(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPostalCode(),
                customer.getCountry(),
                id);
        if(num > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteCustomerById(int id) {
        String sqlQery = "DELETE FROM `db_tech_school`.`customers`\n" +
                "WHERE id =?;\n";
        int num = this.jdbcTemplate.update(sqlQery, id);
        if(num > 0) {
            return true;
        }
        return false;
    }
}
