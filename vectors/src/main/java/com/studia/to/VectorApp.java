package com.studia.to;

import com.studia.to.interfaceAlgebra.Algebra;
import com.studia.to.model.Vector2D;
import com.studia.to.model.Vector3D;
import com.studia.to.calculation.VectorCalculator;

public class VectorApp {

    public static void main(String[] args) {
        VectorCalculator vectorCalculator = new VectorCalculator();
        Algebra v1 = new Vector2D(4,7);
        Algebra v2 = new Vector2D(6,9);
        Algebra v3 = new Vector3D(((Vector2D) v2).getX(),((Vector2D) v2).getY(),7);
        Algebra v4 = new Vector3D(8,9,5);

        System.out.println(vectorCalculator.getLength(v2));
        System.out.println(vectorCalculator.getLength(v3));

        System.out.println(vectorCalculator.getScalarCalculation(v1,v2));
        System.out.println(vectorCalculator.getScalarCalculation(v3,v4));

        System.out.println(vectorCalculator.getAngle(v2));

        System.out.println(vectorCalculator.getVectorCalculation(v3,v4));

    }
}
