package com.studia.to;

import com.studia.to.controller.Controller;
import com.studia.to.view.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        View view = new View();
        Scanner reader = new Scanner(System.in);
        String input = null;
        while (!"n".equals(input)){
            System.out.println("Czy chcesz wprowadzić dane? t/n");
            input = reader.next();
            if(!"n".equals(input))
                view.getInput();
        }
        view.getList();

    }
}
