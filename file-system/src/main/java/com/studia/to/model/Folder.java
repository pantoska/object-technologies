package com.studia.to.model;

import java.util.ArrayList;

public class Folder extends Node {
    private Node parent;
    protected ArrayList<Node> nodeList = new ArrayList<>();

    public Folder(String name, Node parent) {
        super(name);
        this.parent = parent;
    }

    public Folder() {
    }

    public ArrayList<Node> findAll(){
        return nodeList;
    }

    public Node findNode(String name){
        for (Node node: nodeList) {
            if(name.equals(node.getName())){
                return node;
            }
        }
        return null;
    }

    public void addNode(Node node){
        nodeList.add(node);
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node node){
        this.parent = parent;
    }



}
