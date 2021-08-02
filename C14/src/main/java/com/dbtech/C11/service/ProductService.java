package com.dbtech.C11.service;

import com.dbtech.C11.dao.Product;
import com.dbtech.C11.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List<Product> getAllProducts(){
        List<Product> productList = productDAO.getAllProducts();
        return productList;
    }
    public Product getProductById(String code){
        Product product = productDAO.getProductById(code);
        return product;
    }
    public Boolean insertProduct(Product product){
        Boolean result = productDAO.insertProduct(product);
        return result;
    }
    public Boolean updateProductById (Product product){
        Boolean result = productDAO.updateProductById( product);
        return result;
    }
    public Boolean deleteProductById(String code){
        Boolean result = productDAO.deleteProductById(code);
        return result;
    }

}
