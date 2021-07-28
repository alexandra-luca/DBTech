package com.dbtech.C11.dao;

import java.util.List;

public interface ProductDAO {

    public List<Product> getAllProducts();
    public Product getProductById(String code);
    public Boolean insertProduct(Product product);
    public Boolean updateProductById (Product product);
    public Boolean deleteProductById(String code);

}
