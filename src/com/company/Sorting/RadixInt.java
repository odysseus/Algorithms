package com.company.Sorting;

import java.util.LinkedList;

public class RadixInt {

    public static void sort(Integer[] a) {
        int test = 1;
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        for (int i=0; i<30; i++) {
            boolean allZeroes = true;
            for (Integer t : a) {
                if ((t & test) == 0) {
                    left.add(t);
                } else {
                    right.add(t);
                    allZeroes = false;
                }
            }
            for (int j=0; j<a.length; j++) {
                if (!left.isEmpty()) {
                    a[j] = left.pop();
                } else {
                    a[j] = right.pop();
                }
            }
            test *= 2;
            if (allZeroes) {
                boolean done = true;
                for (Integer t: a) {
                    if (t > test) {
                        done = false;
                    }
                }
                if (done) {
                    return;
                }
            }
        }
    }

}
