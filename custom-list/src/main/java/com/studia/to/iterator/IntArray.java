package com.studia.to.iterator;

public class IntArray {
    int[] list;

    public IntArray() {
        list = new int[5];
    }

    public void setList(int[] list) {
        this.list = list;
    }

    public Integer getNumber(int index){
        return list[index];
    }

    public int[] getList(){
        return list;
    }
}
