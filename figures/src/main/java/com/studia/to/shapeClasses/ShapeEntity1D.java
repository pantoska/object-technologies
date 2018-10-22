package com.studia.to.shapeClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ShapeEntity1D extends ShapeEntity {
    private int thickness;

    public abstract double length();

    public Integer getThickness(){
        return thickness;
    }

    public void setThickness(int thickness){
        this.thickness = thickness;
    }
}
