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

    public FileSystemController() {
    }

    public void addNode(String name, Node parent, Node type) {
        node = new Node(name);
        check = new Check(node);
        while(!checkNode()){
            setNode();
        }

        if(type instanceof Folder){
            folder = new Folder(name, parent);
            addFolder(folder);
        }
        else if(type instanceof File){
            file = new File(parent,"blabla",name);
            addFile(file);
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
      for(int i=0; i<nodeList.size();i++){
           if(node.getName().equals(nodeList.get(i).getName())) {
               return false;
           }
           else if(!check.checkName(node.getName()))
               return false;
      }
        return true;
    }

    public Node getNode(String name) {
        for (int i = 0; i < folderList.size(); i++) {
            if (name.equals(folderList.get(i).getName())) {
                return folderList.get(i);
            }
        }
        return null;
    }

    public void printFolderContent(String name) {
        for (int i = 0; i < folderList.size(); i++) {
            if (name.equals(folderList.get(i).getParent().getName()))
                System.out.println(folderList.get(i).getName());
        }
        for (int i = 0; i < fileList.size(); i++) {
            if(name.equals(fileList.get(i).getParent().getName()))
                System.out.println(fileList.get(i).getName());
        }
    }

    public void printAllContent(){
        for(int i=0; i<folderList.size();i++){
            //Folder folder = (Folder) nodeList.get(i);
            System.out.println( folderList.get(i).getName() + " Parent " + folderList.get(i).getParent().getName());
        }
        for(int i=0; i<fileList.size();i++){
            System.out.println( fileList.get(i).getName() + " Parent " + fileList.get(i).getParent().getName());
        }
    }

    private void addFolder(Folder folder){ folderList.add(folder);}
    private void addFile(File file){ fileList.add(file);}


}
