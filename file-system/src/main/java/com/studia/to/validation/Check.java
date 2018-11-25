package com.studia.to.validation;

import com.studia.to.model.Node;

public class Check extends Node {
    private Node created;

    public Check(Node created) {
        this.created = created;
    }

    public boolean checkName(String name){
        return name.matches("[a-zA-Z-0-9-.]+");
    }

    public void setName(String name){
        if(checkName(name))
            created.setName(name);
    }

    public String getName(){
        return created.getName();
    }
}
