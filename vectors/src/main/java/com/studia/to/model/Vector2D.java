package com.studia.to.model;

import com.studia.to.interfaceAlgebra.Algebra;

public class Vector2D implements Algebra {
    private double x;
    private double y;

    public Vector2D() {
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Double abs() {
        return null;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double scalar(Vector2D vector){
        return getX()*vector.getX()+getY()*vector.getY();
    }

    public Vector2D vector(Vector2D vector){
        return new Vector2D(0,0);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
