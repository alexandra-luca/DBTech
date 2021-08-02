package shopifyadvanced.dao.impl;

import shopifyadvanced.dao.model.Product;
import shopifyadvanced.dao.ProductDAO;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {


    @PersistenceContext
    EntityManager em;



    @Override
    public List<Product> getProducts() {
        Query query=em.createQuery("SELECT c FROM Product c");

        List<Product> products = query.getResultList();
        return products;
    }

    @Override
    public Product getProduct(Product product) {
      Product product1=em.find(Product.class,product.getCode());
      return product1;
    }

    @Override
    public boolean insertProducts(Product product) {
       em.persist(product);
       return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        em.persist(product);
        return true;
    }

    @Override
    public boolean deleteProduct(Product product) {
        Product c=em.find(Product.class,product.getCode());

        em.remove(c);
        return true;
    }
}

