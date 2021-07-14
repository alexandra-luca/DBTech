package pizzaFactory;

public class Marguerita implements Pizza {
    private int price = 10;

    public Marguerita () {}

    @Override
    public int getPrice() {

        return price;
    }
}
