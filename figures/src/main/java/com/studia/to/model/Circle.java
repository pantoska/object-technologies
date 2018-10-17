package com.studia.to.model;

import com.studia.to.controller.Shape2D;

public class Circle extends Shape2D {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public void color() {

    }
}
