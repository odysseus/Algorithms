package com.company.Sorting;

import java.util.Vector;

public class Heap<T> {
    private class Node<T> {
        int priority;
        T item;
    }

    Vector<Node> heap;
    int N = 1;
    int maxMin;

    public Heap(int minOrMax) {
        heap = new Vector<Node>(64);
        Node n = new Node<T>();
        heap.insertElementAt(n, 0);
    }

    public void insert(T item, int key) {
        Node insert = new Node();
        insert.item = item;
        insert.priority = key;
        heap.insertElementAt(insert, N++);
    }

}
