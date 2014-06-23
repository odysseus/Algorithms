package com.company.ADTs;

public class Deque<T> {
    private class Node<T> {
        T item;
        Node next = null;
        Node prev = null;
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
        if (first != null) {
            first.prev = newn;
            first = newn;
        } else {
            first = newn;
            last = newn;
        }
        length++;
    }

    public void pushRight(T item) {
        Node newn = new Node();
        newn.item = item;
        newn.next = null;
        newn.prev = last;
        if (last != null) {
            last.next = newn;
            last = newn;
        } else {
            first = newn;
            last = newn;
        }
        length++;
    }

    public T popLeft() {
        T item = (T) first.item;
        if (first.next != null) {
            first = first.next;
            first.prev = null;
        } else {
            first = null;
        }
        length--;
        return item;
    }

    public T popRight() {
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
}
