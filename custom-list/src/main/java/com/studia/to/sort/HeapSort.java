package com.studia.to.sort;

import com.studia.to.iterator.IntArray;

public class HeapSort implements Sort {
    private int n;
    private int largest;
    private IntArray intArray;
    private int left;
    private int right;

    @Override
    public Object sort(Object object) {
        intArray = ((IntArray) object);
        separate(intArray.getList());
        return intArray;
    }

    private void separate(int[] array){
        buildHeap(array);
        for(int i=n; i>0; i--) {
            exchange(0, i);
            n=n-1;
            maxHeap(array, 0);
        }
    }

    private void exchange(int i, int j){
        int t = intArray.getList()[i];
        intArray.getList()[i] = intArray.getList()[j];
        intArray.getList()[j] = t;
    }
    private void buildHeap(int[] array){
        n = array.length-1;
        for(int i=n/2; i>=0; i--){
            maxHeap(array,i);
        }
    }

    private void maxHeap(int[] array, int i){
        left = 2*i;
        right = 2*i+1;

        if(left <= n && array[left] > array[i]){
            largest=left;
        } else {
            largest=i;
        }

        if(right <= n && array[right] > array[largest]) {
            largest=right;
        }
        if(largest!=i) {
            exchange(i, largest);
            maxHeap(array, largest);
        }
    }
}
