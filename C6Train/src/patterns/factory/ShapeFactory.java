package patterns.factory;

public class ShapeFactory {
    public Shape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        if (type.equalsIgnoreCase("square")) {
            return new Square();
        }
        return null;
    }
}
