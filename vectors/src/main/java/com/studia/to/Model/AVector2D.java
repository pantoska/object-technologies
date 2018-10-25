package com.studia.to.Model;

public abstract class AVector2D extends Vector2D implements IAlgebra{
    private Vector2D vector2D;

    Double scalar(Vector2D vector2D){
        return getX()*vector2D.getX() + getY()*vector2D.getY();
    }

    Vector2D vector(Vector2D vector2D){
        return vector2D;
    }
}
