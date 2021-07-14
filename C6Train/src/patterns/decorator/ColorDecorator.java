package patterns.decorator;

public class ColorDecorator extends ShapeDecorator {

    public ColorDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        this.setColor();
    }

    private void setColor() {
        System.out.println("Shape with color");
    }
}
