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
        return (first == null || last == null);
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
        Node n = new Node();
        n.item = item;
        n.next = first;
        if (first != null) {
            first.prev = n;
            first = n;
        } else {
            first = n;
            last = n;
        }
        length++;
    }

    public T pop() {
        T item = (T) first.item;
        if (first.next != null) {
            first = first.next;
            first.prev = null;
        } else {
            first = null;
        }
        return item;
    }

    public void append(T item) {
        Node n = new Node();
        n.item = item;
        n.prev = last;
        if (last != null) {
            last.next = n;
            n = last;
        } else {
            first = n;
            last = n;
        }
        length++;
    }

    public T popLast() {
        T item = (T) last.item;
        if (last.prev != null) {
            last = last.prev;
            last.next = null;
        } else {
            last = null;
        }
        length--;
        return item;
    }

    // Reads the first item without removing the node
    public T readFirst() {
        return (T) first.item;
    }

    // Reads the last item without removing the node
    public T readLast() {
        return (T) last.item;
    }

    public void delete(int i) {
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

    // Returns true if the list contains the given item
    // uses the == operator, which in Java has no fucking consistency
    // so it's not particularly robust
    public boolean contains(T item) {
        Node current = first;
        while (current.next != null) {
            if (current.item == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeAfter(Node n) {
        if (n.next != null) {
            n.next = n.next.next;
        } else {
            n.next = null;
        }
    }

    public void insertAfter(Node n, Node ins) {
        if (!(n == null) && !(ins == null)) {
            ins.next = n.next;
            n.next = ins;
        }
    }

    public void remove(T item) {
        Node current = first;
        while (current.next != null) {
            if (current.item == item) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
    }

    public int max() {
        Node current = first;
        int max = 0;
        while (current.next != null) {
            if ((Integer)current.item > max) {
                max = (Integer)current.item;
            }
            current = current.next;
        }
        return max;
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
