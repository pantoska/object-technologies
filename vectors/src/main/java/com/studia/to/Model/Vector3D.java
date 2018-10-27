package com.studia.to.Model;

import com.studia.to.algebraInterfaces.DecoratorVector3D;

public class Vector3D extends Vector2D implements DecoratorVector3D {
    private double z;

    public double getZ() {
        return z;
    }

    public Vector3D() {super();}

    public Vector3D(double x, double y,double z){
        super(x,y);
        this.z = z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public Double scalar(Vector3D vector) {
        return getX()*vector.getX()+getY()*vector.getY()+getZ()*vector.getZ();
    }

    //vector for 2D return [0,0,getX()*v.getY()-getY()*v.getX()]

    @Override
    public Vector3D vector(Vector3D avector3D) {
        Vector3D v = (Vector3D) avector3D;
        Vector3D vector3D = new Vector3D();
        vector3D.setX(getY()*v.getZ()-getZ()*v.getY());
        vector3D.setY(getZ()*v.getX()-getX()*v.getZ());
        vector3D.setZ(getX()*v.getY()-getY()*v.getX());
        return vector3D;
    }
}
