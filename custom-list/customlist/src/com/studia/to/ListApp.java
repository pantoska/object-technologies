package com.studia.to;

import com.studia.to.iterator.*;

import java.util.ArrayList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {

        List<IntList> mainList = new ArrayList<>();
        IntList intList1 = new IntList();
        IntList intList2 = new IntList();


        intList1.add(12);
        intList1.add(4);
        intList1.add(50);
        intList1.add(55);

        intList1.add(122);
        intList1.add(40);
        intList1.add(90);
        intList1.add(55);

        mainList.add(intList1);
        mainList.add(intList2);

        Iterator iterator = new Maker().iterator(mainList);

        while (iterator.hasNext()){
            for(Integer number: iterator.next().getList())
                System.out.println(number);
        }
    }
}
