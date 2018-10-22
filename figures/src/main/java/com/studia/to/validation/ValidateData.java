package com.studia.to.validation;

public class ValidateData {

    public boolean checkCircleData(Integer x, Integer y, Double radius ){
        if(radius <= 0 || x < 0 || y < 0)
            return false;
        return true;
    }

    public boolean checkRectangle(Integer x, Integer y,Double width, Double height){
        if(width <= 0 || height <= 0 || x < 0 || y < 0)
            return false;
        return true;
    }

    public boolean checkLine(Integer x1, Integer y1, Integer x2, Integer y2){
        if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0)
            return false;
        return true;
    }
}
