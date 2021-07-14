package patterns.command;

import java.util.ArrayList;

public class Broker {
    private ArrayList<Order> orders;

    public Broker() {
        this.orders = new ArrayList<>();
    }

    public void receiveOrder(Order o) {
        orders.add(o);
    }

    public void executeOrders() {
        for (Order o : orders) {
            o.execute();
        }

        orders.clear();
    }
}
