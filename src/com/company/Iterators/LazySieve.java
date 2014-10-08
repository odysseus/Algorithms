package com.company.Iterators;

import java.util.Iterator;

public class LazySieve implements Iterator {

    private Integer current;
    private MergeIterator sieve;

    public LazySieve() {
        current = 1;
        sieve = new MergeIterator();
        sieve.addSeq(2);
    }

    public boolean hasNext() {
        return true;
    }

    public Integer next() {
        if (current == 1) {
            current = 2;
            return 2;
        }
        Integer n = sieve.next();
        while (n - current == 1) {
            current = n;
            n = sieve.next();
        }
        current = n;
        sieve.addSeq(current - 1);
        return current - 1;
    }

}
