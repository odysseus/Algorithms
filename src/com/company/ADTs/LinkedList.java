package com.company.ADTs;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int length = 0;

    private class Node<T> {
        T item;
        Node next;
        Node prev;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int length() {
        return length;
    }

    public T get(int index) {
        if (index > length-1 || isEmpty()) {
            return null;
        } else {
            Node current = first;
            for (int i=0; i<index; i++) {
                current = current.next;
            }
            return (T) current.item;
        }
    }

    private Node getNode(int index) {
        if (index > length-1 || isEmpty()) {
            return null;
        } else {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }

    // Classic stack operations
    public void push(T item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            oldfirst.prev = first;
        }
        length++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T i = (T) first.item;
            first = first.next;
            length--;
            return i;
        }
    }

    // Append adds to the end of the list
    public void append(T item) {
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            first = last;
        } else {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.prev = oldlast;
            oldlast.next = last;
        }
        length++;
    }

    // Limited use, but it removes the final item
    // of the list and returns it
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T i = (T) last.item;
            last = last.prev;
            length--;
            return i;
        }
    }

    public void remove(int i) {
        if (i > length-1 || i < 0 || isEmpty()) {
            Node current = getNode(i);
            // Node is in the middle of the list
            if (current.prev != null && current.next != null) {
                Node remove = current;
                remove.prev.next = remove.next;
                remove.next.prev = remove.prev;
                remove.item = null;
                length--;
                // Node is the last in the list
            } else if (current.prev != null) {
                Node remove = current;
                remove.prev.next = null;
                remove.item = null;
                last = remove.prev;
                length--;
                // Node is the first in the list
            } else {
                Node remove = current;
                remove.next.prev = null;
                remove.item = null;
                first = remove.next;
                length--;
            }
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T i = (T) current.item;
            current = current.next;
            return i;
        }
    }

}
