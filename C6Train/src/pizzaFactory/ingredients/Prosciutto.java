package pizzaFactory.ingredients;

import pizzaFactory.Pizza;
import pizzaFactory.PizzaDecorator;

public class Prosciutto extends PizzaDecorator {
    private int price = 5;

    public Prosciutto(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + price;
    }
}
