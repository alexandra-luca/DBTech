package shopifyadvanced.dao;

import shopifyadvanced.dao.model.Product;

import java.util.List;

public interface ProductDAO {


    public List<Product> getProducts();

    public Product getProduct(Product product);

    public boolean insertProducts(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(Product product);

}
