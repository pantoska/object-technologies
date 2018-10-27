package com.studia.to.calculation;

import com.studia.to.Adapter.VectorAdapter;
import com.studia.to.algebraInterfaces.Algebra;
import com.studia.to.Model.Vector2D;
import com.studia.to.Model.Vector3D;

public class VectorCalculator{
    VectorAdapter vectorAdapter;

    public double getLength(Algebra vector){

        vectorAdapter = new VectorAdapter();

        if(vector instanceof Vector2D){
            Vector2D vector2D = (Vector2D) vector;
            vectorAdapter.getVector(vector2D.getX(), vector2D.getY());
        }
        else if(vector instanceof Vector3D){
            Vector3D vector3D = (Vector3D) vector;
            vectorAdapter.getVector(vector3D.getX(), vector3D.getY(), vector3D.getZ());
        }
        return vectorAdapter.getLength();
    }

    public double getAngle(Algebra vector) {
        if (vector instanceof Vector2D) {
            Vector2D vector2D = (Vector2D) vector;
            vectorAdapter.getVector(vector2D.getX(), vector2D.getY());
        } else if (vector instanceof Vector3D) {
            Vector3D vector3D = (Vector3D) vector;
            vectorAdapter.getVector(vector3D.getX(),vector3D.getY(), vector3D.getZ());
        }

        return vectorAdapter.getAngle();
    }


}
