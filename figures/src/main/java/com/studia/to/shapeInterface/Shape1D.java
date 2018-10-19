package com.studia.to.shapeInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Shape1D implements Shape {

    public abstract double length();
    public abstract double thickness();
}
