package figures_task;

public class Square extends Figure {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть больше нуля");
        }
        this.side = side;
    }

    @Override
    public double findArea() {
        return side * side;
    }

    @Override
    public double findPerimeter() {
        return side * 4;
    }
}
