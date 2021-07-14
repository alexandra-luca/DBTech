package patterns.command;

public class Main {
    public static void main(String[] args) {
        Stock s = new Stock();

        Broker b = new Broker();
        b.receiveOrder(new BuyItem(s));
        b.receiveOrder(new SellItem(s));

        b.executeOrders();
    }
}
