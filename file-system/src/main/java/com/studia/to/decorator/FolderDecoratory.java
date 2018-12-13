package com.studia.to.decorator;

import com.studia.to.model.File;
import com.studia.to.model.Folder;
import com.studia.to.model.Node;
import com.studia.to.validation.Check;

import java.util.ArrayList;
import java.util.Scanner;

public class FolderDecoratory extends Folder {
    Scanner sc = new Scanner(System.in);
    private Node node;
    private Check check;
    private Folder folder;
    private File file;
    protected ArrayList<Folder> folderList = new ArrayList<>();
    protected ArrayList<File> fileList = new ArrayList<>();
    private  StringBuilder stringBuilder = new StringBuilder();

    public FolderDecoratory() {
        node = new Node("root");
        addNode(node);
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

    public void printFolderContent(String name, Integer mode) {
        if(mode == 1){System.out.println(stringBuilder.toString() + name);}
        for(Folder folder: folderList)
            if (name.equals(folder.getParent().getName())) {
                stringBuilder.append("  ");
                printFolderContent(folder.getName(),1);
            }

        for(File file: fileList) {
            if (name.equals(file.getParent().getName())) {
                printFolderContent(file.getName(),1);
                stringBuilder = new StringBuilder();
            }
        }

    }

    public void printAllContent(){
        printFolderContent("root",1);
    }

    private void addFolder(Folder folder){ folderList.add(folder);}
    private void addFile(File file){ fileList.add(file);}
}
