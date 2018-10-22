package com.studia.to.shapeClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ShapeEntity2D extends ShapeEntity {

    public abstract double perimeter();

    public abstract double area();

}