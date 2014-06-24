package com.company.Sorting;

public class Insertion {

    // Basic Sorting Methods
    public static void sort(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            for (int j=i; j > 0 && less(a[j],a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
