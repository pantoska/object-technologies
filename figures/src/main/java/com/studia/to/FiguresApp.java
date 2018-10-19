package com.studia.to;

import com.studia.to.drawing.Window;
import com.studia.to.service.Service;
import com.studia.to.view.View;

import java.util.Scanner;

public class FiguresApp {

    public static void main(String[] args){
        View view = new View();
        Scanner reader = new Scanner(System.in);
        Service service = new Service(view);
        Window window = new Window();
        String input = null;
        service.getInput();
//        while (!"n".equals(input)){
//            System.out.println("Czy chcesz wprowadzić dane? t/n");
//            input = reader.next();
//            if(!"n".equals(input))
//                service.getInput();
//        }
        //service.run();
        service.getList();
        //window.drawShapes();
    }
}
