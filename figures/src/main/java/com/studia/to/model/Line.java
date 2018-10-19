package com.studia.to.model;

import com.studia.to.shapeInterface.Shape1D;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Line extends Shape1D {
    private Point start;
    private Point end;


    @Override
    public double length() {
        return Math.sqrt(Math.pow(end.getX()-start.getX(),2)+Math.pow(end.getY()-start.getX(),2));
    }

    @Override
    public double thickness() {
        return 0;

    }

    @Override
    public void color() {

    }

}
