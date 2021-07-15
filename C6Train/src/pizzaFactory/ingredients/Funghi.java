package pizzaFactory.ingredients;

import pizzaFactory.Pizza;
import pizzaFactory.PizzaDecorator;

public class Funghi extends PizzaDecorator {
    private int price = 6;

    public Funghi(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + price;
    }
}
