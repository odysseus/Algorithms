package com.company.ADTs;

import java.util.Arrays;

public class MinPQ {
    private Comparable[] pq;
    int N;
    boolean resizeable;

    public MinPQ() {
        pq = new Comparable[16];
        N = 0;
        resizeable = true;
    }

    public MinPQ(int size) {
        pq = new Comparable[size];
        N = 0;
        resizeable = false;
    }

    public void add(Comparable item) {
        if (N >= pq.length - 1 && resizeable) {
            resize(pq.length * 2);
        }
        pq[++N] = item;
        swim(N);
    }

    public Comparable remove() {
        Comparable ret = pq[1];
        exch(1,N--);
        sink(1);
        pq[N+1] = null;
        if (N < (pq.length / 4) && resizeable) {
            resize(pq.length / 2);
        }
        return ret;
    }

    private boolean less(int i, int j) {
        if (pq[i] != null && pq[j] != null) {
            return pq[i].compareTo(pq[j]) < 0;
        } else {
            return false;
        }
    }

    private void exch(int i, int j) {
        Comparable swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k, k/2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k*2;
            if (j < N && less(k*2+1, k*2)) j++;
            if (!less(j,k)) break;
            exch(j,k);
            k = j;
        }
    }

    private void resize(int newSize) {
        Comparable[] migrate = new Comparable[newSize];
        for (int i=1; i<=N; i++) {
            migrate[i] = pq[i];
        }
        pq = migrate;
    }

    public String toString() {
        String s = "[";
        if (N >= 1) {
            s += pq[1].toString();
            for (int i = 2; i < N; i++) {
                s += ", " + pq[i].toString();
            }
        }
        s += "]";
        return s;
//        return Arrays.toString(pq);
    }
}