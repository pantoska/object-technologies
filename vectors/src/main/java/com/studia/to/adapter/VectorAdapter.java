package com.studia.to.adapter;

import com.studia.to.interfaceAlgebra.Algebra;
import com.studia.to.model.Vector2D;
import com.studia.to.model.Vector3D;

public class VectorAdapter implements Algebra {

    private Algebra vector;

    public Algebra getVector(double x, double y){
        vector = new Vector2D(x,y);
        return vector;
    }

    public Algebra getVector(double x, double y, double z){
        vector = new Vector3D(x,y,z);
        return vector;
    }

    public Algebra getVector(double length, String angle){
        double radians= Math.toRadians(Integer.parseInt(angle));
        double x = length*Math.cos(radians);
        double y = length*Math.sin(Math.toRadians(radians));
        vector = new Vector2D(x,y);
        return vector;
    }

    public double getLength(){
        if(vector instanceof Vector2D){
            Vector2D vector2D = (Vector2D) vector;
            return Math.sqrt(Math.pow(vector2D.getX(),2)+Math.pow(vector2D.getY(),2));
        }
        else if(vector instanceof Vector3D){
            Vector3D vector3D = (Vector3D) vector;
            return Math.sqrt(Math.pow(vector3D.getVector2D().getX(),2)+Math.pow(vector3D.getVector2D().getY(),2)+Math.pow(vector3D.getZ(),2));
        }
        else
            return 0;
    }

    public double getAngle() {
        if (vector instanceof Vector2D) {
            Vector2D vector2D = (Vector2D) vector;
            return Math.atan2(vector2D.getY(), vector2D.getX());
        }
        else
            return 0;
    }

    @Override
    public Double abs() {
        return null;
    }
}
