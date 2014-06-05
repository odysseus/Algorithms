package com.company.ADTs;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    private Node first;

    private class Node {
        T item;
        Node next;
    }

    public void add(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() { }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
