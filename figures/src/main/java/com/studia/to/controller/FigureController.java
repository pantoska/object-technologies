package com.studia.to.controller;

import com.studia.to.converter.ColorConverter;
import com.studia.to.converter.JSONConverter;
import com.studia.to.converter.ShapeConverter;
import com.studia.to.model.*;
import com.studia.to.model.Point;
import com.studia.to.model.Rectangle;
import com.studia.to.view.ShapeView;
import com.studia.to.service.ShapeService;
import com.studia.to.shapeInterface.ShapeEntity;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FigureController {

    private final static Scanner scanner = new Scanner(System.in);
    private final ShapeService shapeService;
    private final ShapeView shapeView;
    private final ShapeConverter shapeConverter = new ShapeConverter();
    private final JSONConverter jsonConverter = new JSONConverter();
    private final ColorConverter colorConverter = new ColorConverter();
    private final String pathname = "/home/patrycja/TO/Object-technologies/figures/figures.json";

    public FigureController(ShapeService shapeService, ShapeView shapeView) {
        this.shapeService = shapeService;
        this.shapeView = shapeView;
    }

    public void init() {
        shapeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shapeView.setVisible(true);
    }

    public synchronized void start() {
        Runnable runnable = () -> {
            while (true) {
                System.out.println("Podaj jaką figurę chcesz narysować lub wpisz zapisz/otworz");
                String input = scanner.next();
                switch (input) {
                    case "koło":
                        handleCircleEvent();
                        break;
                    case "prostokąt":
                        handleRectangleEvent();
                        break;
                    case "linia":
                        handleLineEvent();
                        break;
                    case "zapisz":
                        handleWriteToFileEvent();
                        break;
                    case "otworz" :
                        handleOpenFileEvent();
                        break;
                    default:
                        break;
                }
            }
        };
        new Thread(runnable).start();
    }

    private void handleCircleEvent() {
        Circle circle = new Circle();
        System.out.println("Podaj punkt x, y, promień ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int radius = scanner.nextInt();

        circle.setCenter(new Point(x, y));
        circle.setRadius(radius);
        setColor(circle);
        shapeService.save(circle);
        shapeView.setShape(shapeConverter.map(circle));
    }

    private void handleRectangleEvent() {
        Rectangle rectangle = new Rectangle();
        System.out.println("Podaj punkt x, y, długość i wysokość");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        rectangle.setPoint(new Point(x,y));
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        setColor(rectangle);
        shapeService.save(rectangle);
        shapeView.setShape(shapeConverter.map(rectangle));

    }

    private void handleLineEvent(){
        Line line = new Line();
        System.out.println("Podaj punkt poczatkowy i koncowy x, y");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        line.setStart(new Point(x1,y1));
        line.setEnd(new Point(x2,y2));
        setColor(line);
        shapeService.save(line);
        shapeView.setShape(shapeConverter.map(line));
    }

    private void setColor(ShapeEntity shapeEntity){
        System.out.println("Podaj kolor rgb");
        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        shapeEntity.setColor(new ColorModel(r,g,b));
        shapeView.setColor( colorConverter.convert(shapeEntity.getColor()));

    }

    private void handleWriteToFileEvent() {
        List<ShapeEntity> shapes = shapeService.getAllShapes();
        try {
            jsonConverter.convertToJson(shapes, pathname);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleOpenFileEvent() {
        List<ShapeEntity> shapes;
        try {
            shapes = jsonConverter.convertToList(pathname);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        viewShapes(shapes);

    }

    private void viewShapes(List<ShapeEntity> shapes){
        for(int i = 0; i < shapes.size(); i++) {
            System.out.println(String.valueOf(i) + ". " + shapes.get(i));
        }
        System.out.println("Wybierz nr figury, ktory chcesz wyswietlic: ");
        Integer nr = scanner.nextInt();
        if(nr >= 0 && nr < shapes.size()) {
            Shape shape = shapeConverter.map(shapes.get(nr));
            Color color = colorConverter.convert(shapes.get(nr).getColor());
            shapeView.setColor(color);
            shapeView.setShape(shape);
        }

    }

}
