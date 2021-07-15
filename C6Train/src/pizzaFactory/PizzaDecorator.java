package pizzaFactory;

public abstract class PizzaDecorator implements Pizza{
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public int getPrice() {
        return decoratedPizza.getPrice();
    }
}
