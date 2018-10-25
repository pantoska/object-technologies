package com.studia.to.Controller;

import com.studia.to.Model.IAlgebra;
import com.studia.to.Model.Vector2D;

public class VectorController implements IAlgebra {

    private Vector2D vector2D;

    public Vector2D getVector(double cos, double sin){
        return vector2D;
    }

    public double getLength(){
        return Math.sqrt(Math.pow(vector2D.getX(),2)+Math.pow(vector2D.getY(),2));
    }

    public double getAngle(){
        return 1;
    }

    @Override
    public Double abs() {
        return null;
    }
}
