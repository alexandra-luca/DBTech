package shopifyadvanced.dao.crudRepository;


import shopifyadvanced.dao.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {


    Product findProductByCode(String code);
    List<Product> findAll();
    void deleteById(String code);

}
