package figures_task;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус круга должен быть больше нуля");
        }
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double findPerimeter() {
        return 2 * Math.PI * radius;
    }
}
