package com.studia.to.model;

import com.studia.to.interfaceAlgebra.Algebra;

public abstract class VectorDecorator implements Algebra {
    abstract Double scalar(Vector3D vector);
    abstract Vector3D vector(Vector3D avector3D);
}
