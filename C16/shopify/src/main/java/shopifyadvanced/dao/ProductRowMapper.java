package shopifyadvanced.dao;

import shopifyadvanced.dao.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product p = new Product();

        p.setCode(resultSet.getString("code"));
        p.setName(resultSet.getString("name"));
        p.setDescription(resultSet.getString("description"));
        p.setStock(resultSet.getInt("stock"));
        p.setPrice(resultSet.getFloat("price"));

        return p;
    }
}
