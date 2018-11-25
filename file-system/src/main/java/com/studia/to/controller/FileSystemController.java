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
        for(int i=0; i<folderList.size();i++) {
            if (folderList.get(i).getParent().getName().equals("root")) {
                firstRow.add(folderList.get(i));
            }
        }
        System.out.println("root");
        for(int i=0; i<firstRow.size();i++){
            System.out.println("    " + firstRow.get(i).getName());
            for(int j=0; j<folderList.size();j++){
                if(folderList.get(j).getParent().getName().equals(firstRow.get(i).getName())) {
                    System.out.println("        " + folderList.get(j).getName());
                    for (int k = 0; k < fileList.size(); k++) {
                        if (fileList.get(k).getParent().getName().equals(firstRow.get(i).getName()))
                            System.out.println("        " + fileList.get(k).getName());
                    }
                }
            }
        }
    }

    private void addFolder(Folder folder){ folderList.add(folder);}
    private void addFile(File file){ fileList.add(file);}


}
