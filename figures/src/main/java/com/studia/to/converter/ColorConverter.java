package com.studia.to.converter;

import com.studia.to.model.ColorModel;
import com.studia.to.shapeInterface.ShapeEntity;

import java.awt.*;

public class ColorConverter {

    public Color convert(ColorModel colorModel){
        Integer r = colorModel.getR();
        Integer g = colorModel.getG();
        Integer b = colorModel.getB();
        return new Color(r,g,b);
    }
}
