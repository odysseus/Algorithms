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
            // Starts at the end closest to the index
            if (index <= length / 2) {
                // Start at front and go forward
                Node current = first;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                return (T) current.item;
            } else {
                // Start at end and go backwards
                Node current = last;
                for (int i=length-1; i>index; i--) {
                    current = current.prev;
                }
                return (T) current.item;
            }
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

    // Reads the first item without removing the node
    public T readFirst() {
        return (T) first.item;
    }

    // Reads the last item without removing the node
    public T readLast() {
        return (T) last.item;
    }

    // Limited use, since using append and removeLast is fundamentally
    // the same as push and pop but less idiomatic. However, what's
    // the use of a doubly linked list if you don't make use of its
    // features so this returns the last element and removes the node
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
            if (current.prev != null && current.next != null) {
                // Node is in the middle of the list
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current.item = null;
                length--;
            } else if (current.prev != null) {
                // Node is the last in the list
                current.prev.next = null;
                current.item = null;
                last = current.prev;
                length--;
            } else if (current.next != null) {
                // Node is the first in the list
                current.next.prev = null;
                current.item = null;
                first = current.next;
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
