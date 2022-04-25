package com.leiqjl;

import java.util.Iterator;

/**
 * 284. Peeking Iterator - Medium
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer peek;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        if (it.hasNext()) {
            peek = it.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = peek;
        peek = it.hasNext() ? it.next() : null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return peek != null;
    }
}
