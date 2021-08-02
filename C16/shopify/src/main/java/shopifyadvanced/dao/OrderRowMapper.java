package shopifyadvanced.dao;

import shopifyadvanced.dao.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order o = new Order();

        o.setId(resultSet.getInt("id"));
        o.setOrderDate(resultSet.getDate("order_date"));
        o.setShippedDate(resultSet.getDate("shipped_date"));
        o.setStatus(resultSet.getString("status"));
        o.setComments(resultSet.getString("comments"));
        o.setCustomerId(resultSet.getInt("customer_id"));

        return o;
    }
}
