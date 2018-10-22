package com.studia.to.converter;

import com.studia.to.model.Circle;
import com.studia.to.model.Line;
import com.studia.to.model.Rectangle;
import com.studia.to.shapeClasses.ShapeEntity;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ShapeConverter {

    public Shape map(ShapeEntity shapeEntity) {
        if (shapeEntity instanceof Circle) {
            Circle circle = (Circle) shapeEntity;
            return getCircle(circle);
        } else if (shapeEntity instanceof Line) {
            Line line = (Line) shapeEntity;
            return getLine(line);
        } else if (shapeEntity instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shapeEntity;
            return getRectangle(rectangle);
        } else
            return null;
    }

    private Ellipse2D getCircle(Circle circle) {
        double x = circle.getCenter().getX();
        double y = circle.getCenter().getY();
        double radius = circle.getRadius();
        return new Ellipse2D.Double(x-radius, y-radius, radius * 2, radius * 2);
    }

    private Line2D getLine(Line line) {
        Integer x1 = line.getStart().getX();
        Integer y1 = line.getStart().getY();
        Integer x2 = line.getEnd().getX();
        Integer y2 = line.getEnd().getY();
        return new Line2D.Double(x1, y1, x2, y2);
    }

    private Rectangle2D getRectangle(Rectangle rectangle) {
        double x = rectangle.getPoint().getX();
        double y = rectangle.getPoint().getY();
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();
        return new Rectangle2D.Double(x, y, width, height);
    }

}
