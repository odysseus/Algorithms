package com.company.ADTs;

import java.util.Vector;

public class MaxHeap<T> {
    private class Node {
        int priority;
        T item;

        public Node() {}
        public Node(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        public String toString() {
            return item.toString();
        }
    }

    Vector<Node> heap;
    int N = 1;

    public MaxHeap() {
        heap = new Vector<>(64);
        Node n = new Node();
        heap.insertElementAt(n, 0);
    }

    public void insert(T item, int priority) {
        Node insert = new Node(item, priority);
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
        heap.set(i, heap.get(j));
        heap.set(j, ni);
    }

    public T remove() {
        swap(1, --N);
        T item = heap.remove(N).item;
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
