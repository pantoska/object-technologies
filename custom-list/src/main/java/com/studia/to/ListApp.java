package com.studia.to;

import com.studia.to.iterator.*;
import com.studia.to.sort.Context;
import com.studia.to.sort.HeapSort;
import com.studia.to.sort.QuickSort;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListApp {
    public static void main(String[] args) {
        Random random = new Random();
        IntArray intArray;
        int[] ints;
        int size = 5;

        List<IntArray> mainList = new ArrayList<>();

        for(int i=0;i<10;i++){
            intArray = new IntArray();
            ints = new int[size];
            for(int j=0;j<size;j++)
                ints[j] = random.nextInt(100);
            intArray.setList(ints);
            mainList.add(intArray);
        }

        Iterator iterator = new Maker().iterator(mainList);

//        System.out.println("Przed posortowaniem: ");
//        while (iterator.hasNext()){
//            for(Integer number: ((IntArray) iterator.next()).getList())
//                System.out.println(number);
//        }

//        Context context = new Context(new QuickSort());
        Context context = new Context(new HeapSort());

        System.out.println("Po posortowaniu: ");
        for (IntArray array : context.iterator(iterator)) {
            System.out.println(" ");
            for (Integer number : array.getList())
                System.out.println(number);
        }
    }
}
