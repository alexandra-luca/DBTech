package com.dbtech.cryptoexchange.customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer=new Customer();
        customer.setFirstName(rs.getString("firstname"));
        customer.setLastName(rs.getString("lastname"));
        customer.setPassword(rs.getString("password"));
        customer.setEmail(rs.getString("email"));
        customer.setAge(rs.getInt("age"));
        customer.setId(rs.getInt("id"));
        return customer;
    }
}
