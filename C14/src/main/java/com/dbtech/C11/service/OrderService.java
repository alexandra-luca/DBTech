package com.dbtech.C11.service;

import com.dbtech.C11.dao.CustomerDAO;
import com.dbtech.C11.dao.Order;
import com.dbtech.C11.dao.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;


    public List<Order> getAllOrders(){
        List<Order> orderList = orderDAO.getAllOrders();
        return orderList;

    }
    public Order getOrderById(int id){
        Order order = orderDAO.getOrderById(id);
        return order;
    }
    public Boolean insertCustomer(Order order){
        Boolean result = orderDAO.insertCustomer(order);
        return result;
    }
    public Boolean updateOrderById (Order order){
        Boolean result = orderDAO.updateOrderById( order);
        return result;
    }
    public Boolean deleteOrderById(int id){
        Boolean result = orderDAO.deleteOrderById(id);
        return result;

    }


}
