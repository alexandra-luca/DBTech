package patterns.builder;

public class Main {
    public static void main(String[] args) {
        House h = new House.HouseBuilder().hasFoundation(true).hasFirstStore(true).build();

        House h2 = new House.HouseBuilder().hasFirstStore(true).build();
    }
}
