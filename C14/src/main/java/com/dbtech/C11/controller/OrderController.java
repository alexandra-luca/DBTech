package com.dbtech.C11.controller;

import com.dbtech.C11.dao.Order;
import com.dbtech.C11.dao.OrderRowMapper;
import com.dbtech.C11.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OrderService orderService;

    @ResponseBody
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        List<Order> orderList = orderService.getAllOrders();
        return orderList;
    }

    @ResponseBody
    @GetMapping("/orders/{id}")
    public Order getOrderById (@PathVariable (name = "id") Integer oid){
        Order order = orderService.getOrderById(oid);
        return order;

    }

    @ResponseBody
    @PutMapping("/orders")
    public Boolean insertIntoOrder(@RequestBody Order order){
        Boolean result = orderService.insertCustomer(order);
        return result;

    }

    @ResponseBody
    @PutMapping("/orders/{id}")
    public Boolean updateOrderById(@PathVariable (name = "id") Integer oid, @RequestBody Order order){
        order.id = oid;
        Boolean result = orderService.updateOrderById(order);
        return result;


    }

    @ResponseBody
    @DeleteMapping("/orders/{id}")
    public Boolean deleteOrderbyId(@PathVariable (name = "id") Integer oid){
        Boolean result = orderService.deleteOrderById(oid);
        return result;


    }
}
