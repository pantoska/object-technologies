package com.studia.to.sort;

import com.studia.to.iterator.IntArray;
import com.studia.to.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private Sort currentSort;

    public Context(Sort currentSort) {
        this.currentSort = currentSort;
    }

    public Sort getCurrentSort(){
        return currentSort;
    }

    public List<IntArray> iterator(Iterator iterator){
        List<IntArray> list = new ArrayList<>();
        while (iterator.hasNext()){
            IntArray list1 = ((IntArray) iterator.next());
            list.add((IntArray)currentSort.sort(list1));
        }
        return list;
    }
}
