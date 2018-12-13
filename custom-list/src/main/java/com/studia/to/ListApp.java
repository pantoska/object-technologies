package com.studia.to;

import com.studia.to.iterator.*;
import com.studia.to.sort.Context;
import com.studia.to.sort.QuickSort;
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

        intList2.add(122);
        intList2.add(40);
        intList2.add(90);
        intList2.add(55);

        mainList.add(intList1);
        mainList.add(intList2);

        Iterator iterator = new Maker().iterator(mainList);

//        System.out.println("Przed posortowaniem: ");
//        while (iterator.hasNext()){
//            for(Integer number: ((IntList) iterator.next()).getList())
//                System.out.println(number);
//        }


        Context context = new Context(new QuickSort());
        List<IntList> list = context.iterator(iterator);

        System.out.println("Po posortowaniu: ");
        for (IntList intList: list) {
            System.out.println(" ");
            for (Integer number : intList.getList())
                System.out.println(number);
        }
    }
}
