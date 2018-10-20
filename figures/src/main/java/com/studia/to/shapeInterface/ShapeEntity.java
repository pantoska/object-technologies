package com.studia.to.shapeInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.studia.to.model.Circle;
import com.studia.to.model.ColorModel;
import com.studia.to.model.Line;
import com.studia.to.model.Rectangle;

import java.awt.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ShapeEntity1D.class, name = "ShapeEntity1D"),
        @JsonSubTypes.Type(value = ShapeEntity2D.class, name = "ShapeEntity2D"),
        @JsonSubTypes.Type(value = Circle.class, name = "Circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle"),
        @JsonSubTypes.Type(value = Line.class, name = "Line"),}
)
public abstract class ShapeEntity {
    private ColorModel color;

    public ColorModel getColor(){
        return color;
    }

    public void setColor(ColorModel color){
        this.color = color;
    }
}
