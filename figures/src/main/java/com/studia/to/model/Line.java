package com.studia.to.model;

import com.studia.to.controller.Shape1D;

public class Line extends Shape1D {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public double length() {
        return 0;
    }

    @Override
    public void color() {

    }
}
