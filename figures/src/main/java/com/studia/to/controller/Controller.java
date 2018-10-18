package com.studia.to.controller;

import com.studia.to.model.Circle;
import com.studia.to.model.Line;
import com.studia.to.model.Point;
import com.studia.to.model.Rectangle;
import com.studia.to.shape.Shape;
import java.util.List;

public class Controller {
    private List<Shape> listOfShapes;

    public Controller(List<Shape> listOfShapes) {
        this.listOfShapes = listOfShapes;
    }

    public void createCircle(Point point, double radius){
        Shape circle = new Circle(point,radius);
        addShapetoList(circle);
    }

    public void createLine(Point start, Point end){
        Shape line = new Line(start, end);
        addShapetoList(line);
    }

    public void createRectangle(double width, double height, Point point){
        Shape rectangle = new Rectangle(width, height, point);
        addShapetoList(rectangle);
    }

    private void addShapetoList(Shape shape){
        listOfShapes.add(shape);
    }

    public List<Shape> getList(){
        return listOfShapes;
    }
}
