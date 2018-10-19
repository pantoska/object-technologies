package com.studia.to.model;

import com.studia.to.shapeInterface.Shape2D;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle extends Shape2D {
    private double width;
    private double height;
    private Point point;


    @Override
    public double perimeter() {
        return 2*width+2*height;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public void color() {
    }
}
