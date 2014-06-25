package com.company.Sorting;

public class MergeBottom {

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }
        for (int k=lo; k<=hi; k++) {
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz<N; sz*=2) {
            for (int lo=0; lo<N-sz; lo+=sz*2) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz*2-1, N-1));
            }
        }
    }

}
