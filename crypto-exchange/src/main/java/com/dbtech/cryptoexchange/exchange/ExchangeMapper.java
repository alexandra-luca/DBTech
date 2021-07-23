package com.dbtech.cryptoexchange.exchange;

import com.dbtech.cryptoexchange.customer.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangeMapper implements RowMapper<Exchange> {
    @Override
    public Exchange mapRow(ResultSet rs, int rowNum) throws SQLException {
        Exchange exchange = new Exchange();
//        exchange.setFirstName(rs.getString("firstname"));
//        exchange.setLastName(rs.getString("lastname"));
//        exchange.setPassword(rs.getString("password"));
//        exchange.setEmail(rs.getString("email"));
//        exchange.setAge(rs.getInt("age"));
        exchange.setId(rs.getInt("id"));
        return exchange;
    }
}
