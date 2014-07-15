package com.company.Sorting;

public class Quick {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        if (hi-lo == 1) {
            if (a[lo].compareTo(a[hi]) > 0 ) {
                exch(a, lo, hi);
                return;
            }
            return;
        }
        int pivot = (lo + hi) / 2;
        int lp = lo+1, rp = hi;
        exch(a, lo, pivot);
        while (rp > lp) {
            while (lp <= hi && a[lp].compareTo(a[lo]) <= 0) lp++;
            while (rp >= lo && a[rp].compareTo(a[lo]) > 0) rp--;
            if (lp < rp) exch(a, lp, rp);
        }
        exch(a, rp, lo);
        int elp = rp;
        while (elp > lo && a[elp].compareTo(a[rp]) == 0) elp--;
        sort(a, lo, elp);
        sort(a, rp+1, hi);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
