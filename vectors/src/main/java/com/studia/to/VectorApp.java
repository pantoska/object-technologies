package com.studia.to;

import com.studia.to.algebraInterfaces.Algebra;
import com.studia.to.Model.Vector3D;
import com.studia.to.calculation.VectorCalculator;

public class VectorApp {

    public static void main(String[] args) {
        VectorCalculator vectorCalculator = new VectorCalculator();
        Algebra v1 = new Vector3D(4,7,9);
        Algebra v2 = new Vector3D(5,6,7);

        double length = vectorCalculator.getLength(v1);
        System.out.println(length);
    }
}
