package com.dbtech.C11.dao;


import java.util.List;

public interface OrderDAO {

    public List<Order> getAllOrders();
    public Order getOrderById(int id);
    public Boolean insertCustomer(Order order);
    public Boolean updateOrderById (Order order);
    public Boolean deleteOrderById(int id);

}
