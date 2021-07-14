package patterns.command;

public class BuyItem implements Order {
    private Stock stock;

    public BuyItem(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.buy();
    }
}
