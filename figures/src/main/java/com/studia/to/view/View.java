package com.studia.to.view;

import com.studia.to.controller.FiguresInit;
import com.studia.to.shapeInterface.Shape;
import com.studia.to.validation.NumbersValidation;
import com.studia.to.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner reader = new Scanner(System.in);
    private NumbersValidation numbersValidation = new NumbersValidation();
    private List<Shape> listOfShapes = new ArrayList<Shape>() ;
    private FiguresInit figuresInit = new FiguresInit(listOfShapes);
    private Point pointStart;
    private Point pointEnd;
    private double radius;
    private double height;
    private double width;
    private int x;
    private int y;

    public void getInput(){
        System.out.println("Podaj jaki rodzaj figury chcesz narysować: ");
//        String input = reader.next();
        String input = "koło";
        switch (input){
            case "koło":
                setCircleData();
                break;
            case "prostokąt":
                setRectangleData();
                break;
            case "linia":
                setLineData();
                break;
            default:
                System.out.println("Wybierz inną figurę");

        }
    }

    private void setLineData() {
        setCoordinates();
        pointStart = new Point(x,y);
        setCoordinates();
        pointEnd = new Point(x,y);
        figuresInit.createLine(pointStart,pointEnd);
    }

    private void setRectangleData() {
        setCoordinates();
        setDimensions();
        pointStart = new Point(x,y);
        figuresInit.createRectangle(width,height,pointStart);
    }

    private void setCircleData() {
        setCoordinates();
        setRadius();
        pointStart = new Point(x,y);
        figuresInit.createCircle(pointStart,radius);
    }

    private void setCoordinates(){
        System.out.println("Podaj współrzędne punktu (x,y)");
//        String inputX = reader.next();
//        String inputY = reader.next();
        String inputX = "1";
        String inputY = "2";
        if(numbersValidation.checkInt(inputX) && numbersValidation.checkInt(inputY)) {
            x = Integer.parseInt(inputX);
            y = Integer.parseInt(inputY);
        }
        else{
            System.out.println("Podaj prawidłowe współrzędne");
            System.exit(-1);
        }
    }

    private void setDimensions(){
        System.out.println("Podaj wymiary prostokąta (wysokość i długość)");
        String h = reader.next();
        String w = reader.next();
        if(numbersValidation.checkDouble(h) && numbersValidation.checkDouble(w)) {
            height = Double.parseDouble(h);
            width  = Double.parseDouble(w);
        }
        else{
            System.out.println("Podaj prawidłowe wymiary");
            System.exit(-1);
        }
    }

    private void setRadius(){
        System.out.println("Podaj promień koła");
//        String r = reader.next();
        String r = "1";
        if(numbersValidation.checkDouble(r)){
            radius = Double.parseDouble(r);
        }
        else{
            System.out.println("Podaj prawidłowy promień");
            System.exit(-1);

        }
    }

    public List<Shape> getList(){
        listOfShapes = figuresInit.getList();
        System.out.println(listOfShapes);
        return listOfShapes;
    }

}
