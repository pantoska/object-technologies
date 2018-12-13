package com.studia.to.iterator;

import java.util.List;

public class Maker implements IteratorMaker {

    @Override
    public Iterator iterator(List<IntArray> list) {
        return new IntIterator(list);
    }
}
