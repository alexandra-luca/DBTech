package shopifyadvanced.service;


import shopifyadvanced.dao.crudRepository.OrderRepository;
import shopifyadvanced.dao.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopifyadvanced.dto.CardModel;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentClient paymentClient;


//    @Autowired
//    OrderDAO orderDAO;

//
//    public List<Order> getAllOrder()
//    {
//        return orderDAO.getAllOrder();
//    }
//
//    public Order getOrderById(Order order)
//    {
//        return  orderDAO.getOrderById(order);
//    }
//
//    public boolean insertOrder(Order order)
//    {
//        return orderDAO.insertOrders(order);
//    }
//
//    public boolean updateOrderById(Order order)
//    {
//        return orderDAO.updateOrderById(order);
//    }
//    public boolean deleteOrder(Order order)
//    {
//        return orderDAO.deleteOrder(order);
//    }


    public List<Order> findAll()
    {
        return orderRepository.findAll();
    }

    public Order findOrderById(Integer id)
    {
        return orderRepository.findOrderById(id);
    }

    public Order save(Order order)
    {
        CardModel cardModel=new CardModel();
        cardModel.setCardName(order.getCardName()).setCardNumber(order.getCardNumber()).setSecurityCode(order.getSecurityCode());
        String payment=paymentClient.postCard(cardModel);
        System.out.println("AM PRIMIT : "+payment);
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id)
    {
        orderRepository.deleteById(id);
    }



}
