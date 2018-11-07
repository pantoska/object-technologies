package com.studia.to.calculation;

import com.studia.to.adapter.VectorAdapter;
import com.studia.to.interfaceAlgebra.Algebra;
import com.studia.to.model.Vector2D;
import com.studia.to.model.Vector3D;

public class VectorCalculator extends Vector3D{
    VectorAdapter vectorAdapter;


    public double getLength(Algebra vector){

        vectorAdapter = new VectorAdapter();

        if(vector instanceof Vector2D){
            Vector2D vector2D = (Vector2D) vector;
            vectorAdapter.getVector(vector2D.getX(), vector2D.getY());
        }
        else if(vector instanceof Vector3D){
            Vector3D vector3D = (Vector3D) vector;
            vectorAdapter.getVector(vector3D.getVector2D().getX(), vector3D.getVector2D().getY(), vector3D.getZ());
        }
        return vectorAdapter.getLength();
    }

    public double getAngle(Algebra vector) {
        if (vector instanceof Vector2D) {
            Vector2D vector2D = (Vector2D) vector;
            vectorAdapter.getVector(vector2D.getX(), vector2D.getY());
        } else if (vector instanceof Vector3D) {
            Vector3D vector3D = (Vector3D) vector;
            vectorAdapter.getVector(vector3D.getVector2D().getX(),vector3D.getVector2D().getY(), vector3D.getZ());
        }

        return vectorAdapter.getAngle();
    }

    public double getScalarCalculation(Algebra vector1, Algebra vector2){
        if(vector1 instanceof Vector3D && vector2 instanceof Vector3D){
            Vector3D v1 = (Vector3D) vector1;
            Vector3D v2 = (Vector3D) vector2;
            return v1.scalar(v2);
        }
        else if (vector1 instanceof Vector2D && vector2 instanceof Vector2D){
            Vector2D v1= (Vector2D) vector1;
            Vector2D v2= (Vector2D) vector2;
            return v1.scalar(v2);
        }
        else return 0;
    }

    public Algebra getVectorCalculation(Algebra vector1, Algebra vector2){
        if(vector1 instanceof Vector3D && vector2 instanceof Vector3D){
            Vector3D v1 = (Vector3D) vector1;
            Vector3D v2 = (Vector3D) vector2;
            return v1.vector(v2);
        }
        else if (vector1 instanceof Vector2D && vector2 instanceof Vector2D){
            Vector2D v1= (Vector2D) vector1;
            Vector2D v2= (Vector2D) vector2;
            return v1.vector(v2);
        }
        else return new Vector2D(0,0);
    }
}
