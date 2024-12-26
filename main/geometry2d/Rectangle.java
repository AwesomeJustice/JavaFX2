package main.geometry2d;

public class Rectangle implements Figure {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Длина и ширина должны быть положительными числами.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle [length=" + length + ", width=" + width + "]";
    }
}