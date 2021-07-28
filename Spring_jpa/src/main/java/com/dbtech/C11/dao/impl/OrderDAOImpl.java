package com.dbtech.C11.dao.impl;

import com.dbtech.C11.dao.Customer;
import com.dbtech.C11.dao.Order;
import com.dbtech.C11.dao.OrderDAO;
import com.dbtech.C11.dao.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    EntityManager entityManager ;


    @Override
    public List<Order> getAllOrders() {
        List<Order> orders  = entityManager.createQuery("SELECT o from Order o", Order.class).getResultList();
        return orders;
    }

    @Override
    public Order getOrderById(int id) {
        Order order = entityManager.find(Order.class, id);
        return order;
    }

    @Override
    @Transactional
    public Boolean insertCustomer(Order order) {
        entityManager.persist(order);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateOrderById( Order order) {
        Order order1 = entityManager.find(Order.class, order.id);
        order1.order_date = order.order_date;
        order1.shipped_date = order.shipped_date;
        order1.status = order.status;
        order1.comments = order.comments;
        order1.customer_id = order.customer_id;
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteOrderById(int id) {
        Order order = entityManager.find(Order.class, id);
        entityManager.remove(order);
        return true;
    }
}
