package com.studia.to.view;

import com.studia.to.controller.Controller;
import com.studia.to.shape.Shape;
import com.studia.to.validation.Validate;
import com.studia.to.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner reader = new Scanner(System.in);
    private Validate validate = new Validate();
    private List<Shape> listOfShapes = new ArrayList<Shape>() ;
    private Controller controller = new Controller(listOfShapes);
    private Point pointStart;
    private Point pointEnd;
    private double radius;
    private double height;
    private double width;
    private int x;
    private int y;

    public void getInput(){
        System.out.println("Podaj jaki rodzaj figury chcesz narysować: ");
        String input = reader.next();
        if(input.equals("koło")){
            getCoordinates();
            getRadius();
            pointStart = new Point(x,y);
            controller.createCircle(pointStart,radius);
        }
        else if(input.equals("prostokąt")){
            getCoordinates();
            getDimensions();
            pointStart = new Point(x,y);
            controller.createRectangle(width,height,pointStart);
        }
        else if(input.equals("linia")){
            getCoordinates();
            pointStart = new Point(x,y);
            getCoordinates();
            pointEnd = new Point(x,y);
            controller.createLine(pointStart,pointEnd);
        }
        else
            System.out.println("Wybierz inną figurę");

    }

    public void getCoordinates(){
        System.out.println("Podaj współrzędne punktu (x,y)");
        String inputX = reader.next();
        String inputY = reader.next();
        if(validate.checkInt(inputX) && validate.checkInt(inputY)) {
            x = Integer.parseInt(inputX);
            y = Integer.parseInt(inputY);
        }
        else{
            System.out.println("Podaj prawidłowe współrzędne");
            System.exit(-1);
        }
    }

    private void getDimensions(){
        System.out.println("Podaj wymiary prostokąta (wysokość i długość)");
        String h = reader.next();
        String w = reader.next();
        if(validate.checkDouble(h) && validate.checkDouble(w)) {
            height = Double.parseDouble(h);
            width  = Double.parseDouble(w);
        }
        else{
            System.out.println("Podaj prawidłowe wymiary");
            System.exit(-1);
        }
    }

    private void getRadius(){
        System.out.println("Podaj promień koła");
        String r = reader.next();
        if(validate.checkDouble(r)){
            radius = Double.parseDouble(r);
        }
        else{
            System.out.println("Podaj prawidłowy promień");
            System.exit(-1);

        }
    }

    public void getList(){
        listOfShapes = controller.getList();
        System.out.println(listOfShapes);
    }
}
