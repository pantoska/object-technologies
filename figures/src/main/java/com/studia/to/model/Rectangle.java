package com.studia.to.model;

import com.studia.to.controller.Shape2D;

public class Rectangle extends Shape2D {
    private double width;
    private double height;
    private Point point;

    public Rectangle(double width, double height, Point point) {
        this.width = width;
        this.height = height;
        this.point = point;
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
