package com.company.Sorting;

import java.util.Vector;
import java.util.Comparator;

public class MaxArrayHeap<T> {
    private class Node<T> {
        int priority;
        Integer item;

        public String toString() {
            return item.toString();
        }
    }

    Vector<Node> heap;
    int N = 1;

    public MaxArrayHeap() {
        heap = new Vector<Node>(64);
        Node n = new Node<T>();
        heap.insertElementAt(n, 0);
    }

    public void insert(int item, int key) {
        Node insert = new Node();
        insert.item = item;
        insert.priority = key;
        heap.insertElementAt(insert, N++);
        upHeap(N-1);
    }

    private void upHeap(int i) {
        if (i != 1) {
            Node current = heap.get(i);
            Node parent = heap.get(i / 2);
            if (current.priority > parent.priority) {
                swap(i, i / 2);
                upHeap(i / 2);
            }
        }
    }

    private void swap(int i, int j) {
        Node ni = heap.get(i);
        Integer swapInt = ni.item;
        int swapPriority = ni.priority;
        Node nj = heap.get(j);
        ni.item = nj.item;
        ni.priority = nj.priority;
        nj.item = swapInt;
        nj.priority = swapPriority;
    }

    public Integer remove() {
        swap(1, --N);
        Integer item = heap.remove(N).item;
        downHeap(1);
        return item;
    }

    private void downHeap(int index) {
        Node self = heap.get(index);
        if (index*2 < N) {
            Node lChild = heap.get(index*2);
            if ((index*2)+1 < N) {
                Node rChild = heap.get((index*2)+1);
                if (lChild.priority > rChild.priority) {
                    if (self.priority < lChild.priority) {
                        swap(index * 2, index);
                        downHeap(index * 2);
                    }
                } else {
                    if (self.priority < rChild.priority) {
                        swap((index * 2) + 1, index);
                        downHeap((index * 2) + 1);
                    }
                }
            } // End has left and right child
            if (self.priority < lChild.priority) {
                swap(index * 2, index);
                downHeap(index * 2);
            }
        } // End has left child only
    }

    public String toString() {
        String s = "[";
        s += heap.get(1).toString();
        for (int i=2; i<N; i++) {
            s += ", " + heap.get(i).toString();
        }
        s += "]";
        return s;
    }

}
