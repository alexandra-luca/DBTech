package pizzaFactory;

import pizzaFactory.ingredients.Funghi;
import pizzaFactory.ingredients.Prosciutto;

public class PizzaFactory {
    private static PizzaFactory instance;

    public static PizzaFactory getInstance() {
        if (instance == null) {
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza createPizza(String name) {
        if(name.equalsIgnoreCase("Marguerita")) {
            return new Marguerita();
        }
        if(name.equalsIgnoreCase("ProsciuttoFunghi")) {
           return new Prosciutto(new Funghi(new Marguerita()));
        }
        return null;
    }
}
