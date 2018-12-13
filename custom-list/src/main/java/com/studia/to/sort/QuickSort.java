package com.studia.to.sort;

import com.studia.to.iterator.IntList;

import java.util.Collections;

public class QuickSort implements Sort {
    @Override
    public Object sort(Object object) {
        IntList intList = ((IntList) object);
        int firstIndex = 0;
        int lastIndex = intList.getList().size()-1;
        quickSort(intList,firstIndex,lastIndex);
        return intList;
    }

    private void quickSort(IntList list, int firstIndex, int lastIndex){
        int i= firstIndex;
        int j= lastIndex;
        int index = (firstIndex+lastIndex)/2;
        int v= list.getNumber(index);
        do {
            while (list.getNumber(i)<v)
                i++;
            while (v<list.getNumber(j))
                j--;
            if (i<=j) {
                Collections.swap(list.getList(), i, j);
                i++;
                j--;
            }
        }
        while (i<=j);
        if (firstIndex<j)
            quickSort(list,firstIndex,j);
        if (i<lastIndex)
            quickSort(list,i,lastIndex);
    }
}
