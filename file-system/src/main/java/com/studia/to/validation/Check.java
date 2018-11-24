package com.studia.to.validation;

import com.studia.to.model.Folder;
import com.studia.to.model.Node;

import java.util.ArrayList;

public class Check extends Node {
    private Node created;
    private ArrayList<Node> listOfNodes;

    public Check(ArrayList<Node> listOfNodes) {
        this.listOfNodes = listOfNodes;
    }

    public boolean checkName(String name){
        for(int i=0; i<listOfNodes.size();i++){
            if(name.equals(listOfNodes.get(i).getName()))
                return true;
        }
        return false;
    }

    public void setName(String name){
        created = new Node();
        created.setName(name);
    }

    public String getName(){
        return created.getName();
    }

}
