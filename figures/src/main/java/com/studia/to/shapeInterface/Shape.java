package com.studia.to.shapeInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.studia.to.model.Circle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Shape1D.class, name = "Shape1D"),
        @JsonSubTypes.Type(value = Shape2D.class, name = "Shape2D"),
        @JsonSubTypes.Type(value = Circle.class, name = "Circle")}
)
public interface Shape {
    void color();
}
