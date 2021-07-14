package patterns.decorator;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        Shape colorCircle = new ColorDecorator(circle);
        Shape colorSquare = new ColorDecorator(square);

        Shape borderColorCircle = new BorderDecorator(new ColorDecorator(new Circle()));
        Shape borderCircle = new BorderDecorator(circle);
        Shape colorBorderCircle = new ColorDecorator(new BorderDecorator(new Circle()));

//        colorCircle.draw();
//        colorSquare.draw();

        borderColorCircle.draw();
        System.out.println("----");
        colorBorderCircle.draw();
    }
}
