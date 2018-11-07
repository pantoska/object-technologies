package com.studia.to.model;

import com.studia.to.interfaceAlgebra.Algebra;

public class Vector3D extends VectorDecorator {
    private double z;
    private Vector2D vector2D;
    public double getZ() {
        return z;
    }

    public Vector3D() {}

    public Vector3D(double x, double y,double z){
        vector2D = new Vector2D(x,y);
        this.z = z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector2D getVector2D() { return vector2D; }

    @Override
    public Double scalar(Vector3D vector) {
        return vector2D.scalar(vector.getVector2D())+getZ()*vector.getZ();
    }

    //vector for 2D return [0,0,getX()*v.getY()-getY()*v.getX()]

    @Override
    public Vector3D vector(Vector3D vector) {
        //vector3D.setX(getY()*v.getZ()-getZ()*v.getY());
        double x = vector2D.getY()*vector.getZ()-getZ()*vector2D.getY();
        //vector3D.setY(getZ()*v.getX()-getX()*v.getZ());
        double y = getZ()*vector.getVector2D().getX()-vector2D.getX()*vector.getZ();
        //vector3D.setZ(getX()*v.getY()-getY()*v.getX());
        double z = vector2D.getX()*vector.getVector2D().getY() - vector2D.getY()* vector.getVector2D().getX();
        return new Vector3D(x,y,z);
    }

    @Override
    public Double abs() {
        return null;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "z=" + z +
                ", vector2D=" + vector2D +
                '}';
    }
}
