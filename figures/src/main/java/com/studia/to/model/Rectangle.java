package com.studia.to.model;

import com.studia.to.shape.Shape2D;

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
        return 2*width+2*height;
    }

    @Override
    public double area() {
        return width*height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void color() {
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", point=" + point +
                '}';
    }
}
