package com.studia.to.iterator;

import java.util.List;

/**
 * Klasa obsługująca dostęp do danych zawartych w liście
 */
public class IntIterator implements Iterator{
    private List<IntList> intCollection;
    private int currentPosition = 0;

    public IntIterator(List<IntList> intCollection) {
        this.intCollection = intCollection;
    }

    @Override
    public boolean hasNext() {
        if(currentPosition >= intCollection.size() || intCollection.get(currentPosition) == null)
            return false;
        return true;
    }

    @Override
    public IntList next() {
        return intCollection.get(currentPosition++);
    }

}
