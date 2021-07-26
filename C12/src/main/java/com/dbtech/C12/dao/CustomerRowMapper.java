package com.dbtech.C11.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer c = new Customer();

        c.setId(resultSet.getInt("id"));
        c.setUsername(resultSet.getString("username"));
        c.setLastName(resultSet.getString("last_name"));
        c.setFirstName(resultSet.getString("first_name"));
        c.setPhone(resultSet.getString("phone"));
        c.setAddress(resultSet.getString("address"));
        c.setCity(resultSet.getString("city"));
        c.setPostalCode(resultSet.getString("postal_code"));
        c.setCountry(resultSet.getString("country"));
        return c;
    }
}