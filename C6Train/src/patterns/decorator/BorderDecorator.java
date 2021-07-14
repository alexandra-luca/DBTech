package patterns.decorator;

public class BorderDecorator extends ShapeDecorator {
    public BorderDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        this.setBorder();
    }

    private void setBorder() {
        System.out.println("Shape with border");
    }
}
