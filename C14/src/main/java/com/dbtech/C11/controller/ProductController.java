package com.dbtech.C11.controller;

import com.dbtech.C11.dao.Product;
import com.dbtech.C11.dao.ProductRowMapper;
import com.dbtech.C11.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @ResponseBody
    @GetMapping("/products")
    public List<Product> getAllProducts (){
        List<Product> productList = productService.getAllProducts();
        return productList;
    }

    @ResponseBody
    @GetMapping ("/products/{code}")
    public Product getProductById(@PathVariable (name = "code") String pcode){
        Product product = productService.getProductById(pcode);
        return product;
    }

    @ResponseBody
    @PutMapping("/products")
    public Boolean insertProduct(@RequestBody Product product){
        Boolean result = productService.insertProduct(product);
        return result;

    }

    @ResponseBody
    @PutMapping("/products/{code}")
    public Boolean updateProductById(@PathVariable (name = "code") String pcode, @RequestBody Product product){
        product.code = pcode;
        Boolean result = productService.updateProductById(product);
        return result;

    }

    @ResponseBody
    @DeleteMapping("products/{code}")
    public Boolean deleteProduct(@PathVariable (name = "code") String pcode){
        Boolean result = productService.deleteProductById(pcode);
        return result;

    }
}
