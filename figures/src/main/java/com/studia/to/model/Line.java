package com.studia.to.model;

import com.studia.to.shape.Shape1D;

public class Line extends Shape1D {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public double length() {
        return Math.sqrt(Math.pow(end.getX()-start.getX(),2)+Math.pow(end.getY()-start.getX(),2));
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public double thickness() {
        return 0;

    }

    @Override
    public void color() {

    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
