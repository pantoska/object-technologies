package com.studia.to.shapeInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ShapeEntity1D extends ShapeEntity {

    public abstract double length();

    public abstract double thickness();
}
