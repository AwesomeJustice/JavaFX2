package main;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle2D extends Shape2D {
    private double radius;

    public Circle2D(double x, double y, double radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public boolean contains(double px, double py) {
        double dx = px - x;
        double dy = py - y;
        return Math.sqrt(dx * dx + dy * dy) <= radius;
    }
}