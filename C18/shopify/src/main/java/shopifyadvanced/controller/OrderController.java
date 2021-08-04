package shopifyadvanced.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import shopifyadvanced.dao.model.Customer;
import shopifyadvanced.dao.model.Order;
import shopifyadvanced.service.CustomerService;
import shopifyadvanced.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;
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
    public ResponseEntity<String> getOrderById(@PathVariable(name = "id") Integer oid, @RequestHeader(value = "Authorization",required = false) String auth) {
        String prefix = "Basic ";
        if (auth == null)
        {
            ResponseEntity<String> responseEntity = new ResponseEntity<>("Authorization not valid!", HttpStatus.FORBIDDEN);
            return responseEntity;
        }
        String encoded_credentials = auth.substring(prefix.length());
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encoded_credentials);
        String decoded_credentials = new String(decodedBytes);
        String [] stringArray = decoded_credentials.split(",");
        String username = stringArray[0];
        String password = stringArray[1];
        Customer c = customerService.findCustomerByUsernameAndPassword(username,password);
        if (c == null)
        {
            ResponseEntity<String> responseEntity = new ResponseEntity<>("Authorization not valid!", HttpStatus.FORBIDDEN);
            return responseEntity;
        }
        return new ResponseEntity<String>(orderService.findOrderById(oid).toString(),HttpStatus.OK);
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
