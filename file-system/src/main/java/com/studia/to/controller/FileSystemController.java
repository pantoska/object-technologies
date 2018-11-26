package com.studia.to.controller;

import com.studia.to.model.File;
import com.studia.to.model.Folder;
import com.studia.to.model.Node;
import com.studia.to.validation.Check;

import java.util.ArrayList;
import java.util.Scanner;

public class FileSystemController extends Folder {
    Scanner sc = new Scanner(System.in);
    private Node node;
    private Check check;
    private Folder folder;
    private File file;
    protected ArrayList<Folder> folderList = new ArrayList<>();
    protected ArrayList<File> fileList = new ArrayList<>();
    private ArrayList<Node> firstRow = new ArrayList<>();

    public FileSystemController() {
    }

    public void addNode(String name, Node parent, Node type) {
        node = new Node(name);
        check = new Check(node);
        while(!checkNode())
            setNode();
        if(type instanceof Folder){
            folder = new Folder(name, parent);
            addFolder(folder);
        }
        else if(type instanceof File){
            file = new File(parent,"blabla",name);
            addFile(file);
        }
        addNode(node);
    }

    public void setNode(){
        System.out.println("Musisz zmienić nazwę folderu,podaj nową nazwę");
        String newName = sc.nextLine();
        node.setName(newName);
    }

    private boolean checkNode(){
      for(int i=0; i<nodeList.size();i++){
           if(node.getName().equals(nodeList.get(i).getName()))
               return false;
           else if(!check.checkName(node.getName()))
               return false;
      }
        return true;
    }

    public Node getNode(String name) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (name.equals(nodeList.get(i).getName()))
                return nodeList.get(i);
        }
        return null;
    }

    public void printFolderContent(String name) {
        for(Folder folder: folderList)
            if(name.equals(folder.getParent().getName()))
                System.out.println("        " + folder.getName());

        for(File file: fileList)
            if(name.equals(file.getParent().getName()))
                System.out.println("        " + file.getName());
    }

    public void printAllContent(){
        setfirstRow();
        for(Node node: firstRow){
            System.out.println("    " + node.getName());
            printFolderContent(node.getName());
       }
    }

    private void setfirstRow(){
        for(Folder folder: folderList) {
            if (folder.getParent().getName().equals("root"))
                firstRow.add(folder);
        }
        for (File file: fileList){
            if (file.getParent().getName().equals("root"))
                firstRow.add(file);
        }
        System.out.println("root");
    }
    private void addFolder(Folder folder){ folderList.add(folder);}
    private void addFile(File file){ fileList.add(file);}
}
