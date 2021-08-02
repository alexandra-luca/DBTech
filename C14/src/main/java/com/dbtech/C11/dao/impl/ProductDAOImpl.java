package com.dbtech.C11.dao.impl;

import com.dbtech.C11.dao.Customer;
import com.dbtech.C11.dao.Product;
import com.dbtech.C11.dao.ProductDAO;
import com.dbtech.C11.dao.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    EntityManager entityManager ;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products  = entityManager.createQuery("SELECT p from Product p", Product.class).getResultList();
        return products;
    }

    @Override
    public Product getProductById(String  pcode) {
        Product product = entityManager.find(Product.class, pcode);
        return product;
    }

    @Override
    @Transactional
    public Boolean insertProduct(Product product) {
        entityManager.persist(product);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateProductById( Product product) {
        Product product1 = entityManager.find(Product.class, product.code);
        product1.name = product.name;
        product1.description = product.description;
        product1.stock = product.stock;
        product1.price = product.price;
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteProductById(String pcode) {
        Product product = entityManager.find(Product.class, pcode);
        entityManager.remove(product);
        return true;
    }
}
