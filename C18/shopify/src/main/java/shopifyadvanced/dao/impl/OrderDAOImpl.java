package shopifyadvanced.dao.impl;


import shopifyadvanced.dao.model.Order;
import shopifyadvanced.dao.OrderDAO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {


    @PersistenceContext
    EntityManager em;

    @Override
    public List<Order> getAllOrder() {
        Query query=em.createQuery("SELECT c FROM Order c");
        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public Order getOrderById(Order order) {
        Order order1=em.find(Order.class, order.getId());
        return  order1;

    }

    @Override
    public Boolean insertOrders(@RequestBody @DateTimeFormat(pattern = "dd.MM.yyyy") Order order) {
        em.persist(order);

        return true;
    }

    @Override
    public Boolean updateOrderById(Order order) {
        em.persist(order);
        return true;
    }

    @Override
    public Boolean deleteOrder(Order order) {
        Order c=em.find(Order.class,order.getId());

        em.remove(c);
        return true;
    }

}
