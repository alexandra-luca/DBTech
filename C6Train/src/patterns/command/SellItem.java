package patterns.command;

public class SellItem implements Order {
    private Stock stock;

    public SellItem(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.sell();
    }
}
