package com.dbtech.C11.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer c = new Customer();

        c.setId(resultSet.getInt("id"));
        c.setFirstName(resultSet.getString("first_name"));
        // TODO restul proprietatilor

        return c;
    }
}
