package shopifyadvanced.controller;

import shopifyadvanced.dao.model.Order;
import shopifyadvanced.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
//
//    @GetMapping("/orders")
//    @ResponseBody
//    public List<Order> getAllOrder() {
//
//        return orderService.getAllOrder();
//    }
//
//    @GetMapping("/orders/{id}")
//    @ResponseBody
//    public Order getOrderById(@PathVariable(name = "id") Integer oid) {
//
//        Order order=new Order();
//        order.setId(oid);
//
//        return  orderService.getOrderById(order);
//    }
//
//    @PutMapping("/orders")
//    @ResponseBody
//    public Boolean insertOrders(@RequestBody @DateTimeFormat(pattern = "dd.MM.yyyy") Order order) {
//       return orderService.insertOrder(order);
//    }
//
//    @PutMapping("/orders/{id}")
//    @ResponseBody
//    public Boolean updateOrderById(@PathVariable(name = "id") Integer oid, @RequestBody Order order) {
//        order.setId(oid);
//       return orderService.updateOrderById(order);
//    }
//
//    @DeleteMapping("/orders/{id}")
//    @ResponseBody
//    public Boolean deleteOrderById(@PathVariable(name = "id") Integer oid){
//
//        Order order=new Order();
//        order.setId(oid);
//        order=orderService.getOrderById(order);
//        return orderService.deleteOrder(order);
//
//
//    }


    @GetMapping("/orders")
    @ResponseBody
    public List<Order> getAllOrder() {

        return orderService.findAll();
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable(name = "id") Integer oid) {

        return orderService.findOrderById(oid);
    }

    @PutMapping("/orders")
    @ResponseBody
    public Order insertOrders(@RequestBody @DateTimeFormat(pattern = "dd.MM.yyyy") Order order) {

        return orderService.save(order);
    }

    @PutMapping("/orders/{id}")
    @ResponseBody
    public Boolean updateOrderById(@PathVariable(name = "id") Integer oid, @RequestBody Order order) {
        Order order1 = orderService.findOrderById(oid);

        if (order1 != null) {
            order1 = order;
            orderService.save(order1);
        } else {
            insertOrders(order);
        }
        return true;

    }
    @DeleteMapping("/orders/{id}")
    @ResponseBody
    public void deleteOrderById(@PathVariable(name = "id") Integer id) {
        orderService.deleteOrder(id);
    }

}
