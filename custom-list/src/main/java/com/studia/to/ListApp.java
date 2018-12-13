package com.studia.to;

import com.studia.to.iterator.*;
import com.studia.to.sort.Context;
import com.studia.to.sort.QuickSort;
import java.util.ArrayList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {

        List<IntArray> mainList = new ArrayList<>();
        IntArray intArray1 = new IntArray();
        IntArray intArray2 = new IntArray();
        IntArray intArray3 = new IntArray();

        int[] ints1 = {6, 7, 44, 1, 67};
        int[] ints2 = {444, 72, 54, 111, 60};
        int[] ints3 = {14, 62, 53, 191, 220};

        intArray1.setList(ints1);
        intArray2.setList(ints2);
        intArray3.setList(ints3);

        mainList.add(intArray1);
        mainList.add(intArray2);
        mainList.add(intArray3);

        Iterator iterator = new Maker().iterator(mainList);

//        System.out.println("Przed posortowaniem: ");
//        while (iterator.hasNext()){
//            for(Integer number: ((IntArray) iterator.next()).getList())
//                System.out.println(number);
//        }


        Context context = new Context(new QuickSort());
        List<IntArray> list = context.iterator(iterator);

        System.out.println("Po posortowaniu: ");
        for (IntArray intArray : list) {
            System.out.println(" ");
            for (Integer number : intArray.getList())
                System.out.println(number);
        }
    }
}
