package shopifyadvanced.controller;

import shopifyadvanced.dao.model.Product;
import shopifyadvanced.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
//
//    @GetMapping("/products")
//    @ResponseBody
//    public List<Product> getAllProducts() {
//
//        return productService.getProducts();
//    }
//
//    @GetMapping("/products/{code}")
//    @ResponseBody
//    public Product getProductById(@PathVariable(name = "code") String pcode) {
//
//        Product product=new Product();
//        product.setCode(pcode);
//
//        return productService.getProductById(product);
//    }
//
//    @PutMapping("/products")
//    @ResponseBody
//    public Boolean insertProducts(@RequestBody Product product) {
//        return productService.insertProduct(product);
//    }
//
//    @PutMapping("/products/{code}")
//    @ResponseBody
//    public Boolean updateProductById(@PathVariable(name = "code") String pcode, @RequestBody Product product) {
//
//        product.setCode(pcode);
//        return productService.updateProduct(product);
//    }
//
//    @DeleteMapping("/products/{code}")
//    @ResponseBody
//    public Boolean deleteProductById(@PathVariable(name = "code") String pcode) {
//
//        Product product=new Product();
//        product.setCode(pcode);
//        product=productService.getProductById(product);
//
//        return productService.deleteProduct(product);
//    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {

        return productService.findAll();
    }
    @GetMapping("/products/{code}")
    @ResponseBody
    public Product findProductByCode(@PathVariable(name = "code") String pcode) {

        return productService.findProductByCode(pcode);
    }

    @PutMapping("/products")
    @ResponseBody
    public Product insertProducts(@RequestBody Product product) {
        return productService.save(product);
    }
    @PutMapping("/products/{code}")
    @ResponseBody
    public Boolean updateProductById(@PathVariable(name = "code") String pcode, @RequestBody Product product) {

        Product product1 = productService.findProductByCode(pcode);

        if (product1 != null) {
            product1 = product;
            productService.save(product1);
        } else {
            insertProducts(product);
        }
        return true;
    }
    @DeleteMapping("/products/{code}")
    @ResponseBody
    public void deleteProductById(@PathVariable(name = "code") String pcode) {

        productService.deleteProduct(pcode);
    }

}
