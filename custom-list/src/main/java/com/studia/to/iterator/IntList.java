package com.studia.to.iterator;

import java.util.ArrayList;
import java.util.List;

public class IntList {
    List<Integer> list;

    public IntList() {
        list = new ArrayList<>();
    }

    public void add(int number){
        list.add(number);
    }

    public Integer getNumber(int index){
        return list.get(index);
    }

    public List<Integer> getList(){
        return list;
    }
}
