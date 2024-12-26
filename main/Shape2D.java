package main;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape2D {
    protected double x, y;
    protected Color color;

    public Shape2D(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(GraphicsContext gc);

    public boolean contains(double px, double py) {
        return false;  // Заглушка
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
}