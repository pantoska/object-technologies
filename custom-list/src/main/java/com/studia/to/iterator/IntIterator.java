package com.studia.to.iterator;

import java.util.List;

public class IntIterator implements Iterator{
    private List<IntArray> intCollection;
    private int currentPosition = 0;

    public IntIterator(List<IntArray> intCollection) {
        this.intCollection = intCollection;
    }

    @Override
    public boolean hasNext() {
        if(currentPosition >= intCollection.size() || intCollection.get(currentPosition) == null)
            return false;
        return true;
    }

    @Override
    public Object next() {
        return intCollection.get(currentPosition++);
    }

}
