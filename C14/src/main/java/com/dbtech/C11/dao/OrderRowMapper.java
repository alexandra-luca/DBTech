package com.dbtech.C11.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper {

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order o = new Order();

        o.setId(resultSet.getInt("id"));
        o.setOrder_date(resultSet.getDate("order_date"));
        o.setShipped_date(resultSet.getDate("shipped_date"));
        o.setStatus(resultSet.getString("status"));
        o.setComments(resultSet.getString("comments"));
        o.setCustomer_id(resultSet.getInt("customer_id"));
        return o;
    }
}
