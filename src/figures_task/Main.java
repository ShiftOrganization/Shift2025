package figures_task;

public class Main {
    public static void main(String[] args) {
        Figure square1 = new Square(2.5);
        Figure triangle1 = new Triangle(3,6,7);
        Figure circle1 = new Circle(1.5);

        System.out.println("Площадь квадрата: " + square1.findArea());
        System.out.println("Периметр квадрата: " + square1.findPerimeter());
        System.out.println("Площадь треугольника: " + triangle1.findArea());
        System.out.println("Периметр треугольника: " + triangle1.findPerimeter());
        System.out.println("Площадь круга: " + circle1.findArea());
        System.out.println("Периметр круга (длина окружности): " + circle1.findPerimeter());
    }
}