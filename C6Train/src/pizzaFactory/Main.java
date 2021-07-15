package pizzaFactory;

public class Main {
    public static void main(String[] args) {
        PizzaFactory  italianPizzaFactory = PizzaFactory.getInstance();
        System.out.println(italianPizzaFactory);
        Pizza first = italianPizzaFactory.createPizza("Marguerita");
        Pizza second= italianPizzaFactory.createPizza("ProsciuttoFunghi");
        System.out.println(first.getPrice());
        System.out.println(second.getPrice());
    }
}
