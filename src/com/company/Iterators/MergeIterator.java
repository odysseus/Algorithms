package com.company.Iterators;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MergeIterator implements Iterator{

    private ArrayList<MultiplesOf> seqs;

    public MergeIterator() {
        seqs = new ArrayList<>(8);
    }

    public boolean hasNext() {
        return true;
    }

    public Integer next() throws NoSuchElementException {
        if (seqs.size() == 0) {
            throw new NoSuchElementException("No available sequences, use addSeq() first");
        } else {
            // Iterate over the seqs to find the smallest value
            Integer least = seqs.get(0).peek();
            for (MultiplesOf s : seqs) {
                if (s.peek() < least) {
                    least = s.peek();
                }
            }

            // Advance all seqs that equal the smallest value
            for (MultiplesOf s : seqs) {
                if (s.peek().equals(least)) {
                    s.next();
                }
            }

            // Return the next value in the sequence
            return least;
        }
    }

    public void addSeq(Integer v) {
        MultiplesOf s = new MultiplesOf(v);
        seqs.add(s);
    }


}
