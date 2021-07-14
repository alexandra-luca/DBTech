package patterns.command;

public class Stock {
    private String name = "MyStock";
    private int value = 3;
    private int quantity = 10;

    public void buy() {
        System.out.println("Am cumparat actiuni");
    }

    public void sell() {
        System.out.println("Am vandut actiuni " + value * quantity);
    }
}
