package com.studia.to.sort;

import com.studia.to.iterator.IntArray;

public class QuickSort implements Sort {
    @Override
    public Object sort(Object object) {
        IntArray intArray = ((IntArray) object);
        int firstIndex = 0;
        int lastIndex = intArray.getList().length-1;
        quickSort(intArray.getList(),firstIndex,lastIndex);
        return intArray;
    }

    private void quickSort(int[] list, int firstIndex, int lastIndex){
        int temp;
        int i= firstIndex;
        int j= lastIndex;
        int index = (firstIndex+lastIndex)/2;
        int v= list[index];
        do {
            while (list[i]<v)
                i++;
            while (v<list[j])
                j--;
            if (i<=j) {
                temp=list[i];
                list[i]=list[j];
                list[j]=temp;
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
