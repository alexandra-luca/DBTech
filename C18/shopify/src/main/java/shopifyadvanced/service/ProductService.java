package shopifyadvanced.service;


import shopifyadvanced.dao.crudRepository.ProductRepository;
import shopifyadvanced.dao.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

//    @Autowired
//    ProductDAO productDAO;
//
//    public List<Product> getProducts() {
//        return productDAO.getProducts();
//    }
//
//    public Product getProductById(Product product) {
//        return productDAO.getProduct(product);
//    }
//
//    public boolean insertProduct(Product product) {
//        return productDAO.insertProducts(product);
//    }
//
//    public boolean updateProduct(Product product)
//    {
//        return  productDAO.updateProduct(product);
//    }
//
//    public boolean deleteProduct(Product product)
//    {
//        return productDAO.deleteProduct(product);
//    }

    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    public Product findProductByCode(String code)
    {
        return productRepository.findProductByCode(code);
    }

    public Product save(Product product)
    {
        return  productRepository.save(product);
    }

    public void deleteProduct(String code)
    {
        productRepository.deleteById(code);
    }


}
