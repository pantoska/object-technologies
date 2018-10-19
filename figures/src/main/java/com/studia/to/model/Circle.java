package com.studia.to.model;

import com.studia.to.shapeInterface.Shape2D;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Circle extends Shape2D {
    private Point center;
    private double radius;

     @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public void color() {

    }

 }
