package patterns.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape c = factory.createShape("circle");
        Shape s = factory.createShape("square");

        c.draw();
        s.draw();

        // varianta clasica
        Circle c1 = new Circle();
        Square s1 = new Square();
        c1.draw();
        s1.draw();
    }
}
