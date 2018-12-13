package com.studia.to.sort;

import com.studia.to.iterator.IntList;
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

    public List<IntList> iterator(Iterator iterator){
        List<IntList> list = new ArrayList<>();
        while (iterator.hasNext()){
            IntList list1 = ((IntList) iterator.next());
            list.add((IntList)currentSort.sort(list1));
        }
        return list;
    }
}
