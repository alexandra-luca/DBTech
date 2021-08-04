package shopifyadvanced.dao;

import shopifyadvanced.dao.model.Order;

import java.util.List;

public interface OrderDAO {


    public List<Order> getAllOrder();

    public Order getOrderById(Order order);

    public Boolean insertOrders(Order order);

    public Boolean updateOrderById(Order order);

    public Boolean deleteOrder(Order order);

}
