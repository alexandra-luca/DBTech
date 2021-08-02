package shopifyadvanced.dao.crudRepository;

import shopifyadvanced.dao.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findOrderById(Integer id);
    List<Order> findAll();
    void deleteById(Integer id);


}
