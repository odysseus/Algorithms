package com.company.ADTs;

public class Deque<T> {
    private class Node<T> {
        T item;
        Node next;
        Node prev;
    }

    private Node first;
    private Node last;
    private int length = 0;

    public boolean isEmpty() {
        return (first == null || last == null);
    }

    public int size() {
        return length;
    }

    public void pushLeft(T item) {
        Node newn = new Node();
        newn.item = item;
        newn.next = first;
        newn.prev = null;
        if (isEmpty()) {
            first = newn;
            last = newn;
        } else {
            first = newn;
        }
        length++;
    }

    public void pushRight(T item) {
        Node newn = new Node();
        newn.item = item;
        newn.next = null;
        newn.prev = last;
        if (isEmpty()) {
            first = newn;
            last = newn;
        } else {
            last.next = newn;
            last = newn;
        }
        length++;
    }

    public T popLeft() {
        Node start = first;
        T item = (T) start.item;
        first = start.next;
        start = null;
        length--;
        return item;
    }

    public T popRight() {
        Node end = last;
        T item = (T) end.item;
        last = end.prev;
        end = null;
        length--;
        return item;
    }
}
