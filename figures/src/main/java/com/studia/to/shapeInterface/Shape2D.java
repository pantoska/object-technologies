package com.studia.to.shapeInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Shape2D implements Shape{

    public abstract double perimeter();
    public abstract double area();

}