package com.company.Iterators;


import java.util.Iterator;

public class MultiplesOf implements Iterator {

    private final Integer value;
    private Integer current;

    public MultiplesOf(int v) {
        value = v;
        current = v;
    }

    public boolean hasNext() {
        return true;
    }

    public Integer next() {
        current += value;
        return current;
    }

    public Integer peek() {
        return current + value;
    }

}
