package com.studia.to.decorator;

import com.studia.to.model.Folder;
import com.studia.to.model.Node;
import com.studia.to.validation.Check;

import java.util.Scanner;

public class DecoratorFolder extends Folder {
    private Node node;
    private Check check = new Check(findAll());
    Scanner sc = new Scanner(System.in);

    public DecoratorFolder(String name, Node parent) {
        super(name, parent);
    }

    public DecoratorFolder() {
    }

    public void addNode(String name) {
        node = new Node(name);
        while(checkNode()){
            setNode();
        }
        addNode(node);
        System.out.println("Dodano nowy folder");
        System.out.println("Rozmiar listy " + findAll().size());

    }

    public void setNode(){
        System.out.println("Musisz zmienić nazwę folderu,podaj nową nazwę");
        String newName = sc.nextLine();
        node.setName(newName);
    }

    private boolean checkNode(){
        if(check.checkName(node.getName())) {
            return true;
        }return false;
    }

    public void printFolderContent(){

    }

    public void printAllContent(){

    }
}
