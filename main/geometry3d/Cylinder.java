package main.geometry3d;

import main.geometry2d.Figure;

public class Cylinder {
    private Figure base;
    private double height;

    public Cylinder(Figure base, double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Высота должна быть положительным числом.");
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }

    @Override
    public String toString() {
        return "Cylinder [base=" + base + ", height=" + height + "]";
    }
}