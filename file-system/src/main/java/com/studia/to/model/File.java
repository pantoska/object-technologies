package com.studia.to.model;

public class File extends Node {
    Node parent;
    String value;

    public File(Node parent, String value) {
        this.parent = parent;
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
