package com.studia.to;

import com.studia.to.decorator.DecoratorFolder;
import com.studia.to.model.Folder;
import com.studia.to.model.Node;

import java.util.Scanner;

public class FileSystemApp {

    public static void main(String [ ] args) {
        DecoratorFolder decoratorFolder;
        Scanner reader = new Scanner(System.in);
        Folder root = new Folder();
        String input;
        String condition = "tak";

        System.out.println("Stwórz root, podaj nazwę");
        input = reader.next();
        decoratorFolder = new DecoratorFolder(input,root);
        while(condition.equals("tak")){
            System.out.println("Podaj nazwę folderu");
            input = reader.next();
            decoratorFolder.addNode(input);
            System.out.println("Czy chcesz dodać nowy folder?");
            condition = reader.next();
        }

    }
}
