package com.company.ADTs;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private class Node<T> {
        T item;
        Node next;
    }

    private Node first;
    private int N=0;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        Node n = new Node();
        n.item = item;
        n.next = first;
        first = n;
        N++;
    }

    public T pop() {
        T item = (T) first.item;
        first = first.next;
        N--;
        return item;
    }

    public T peek() {
        return (T) first.item;
    }

    public static Stack<String> copy(Stack<String> toCopy) {
        Stack<String> result = new Stack<String>();
        for (String str : toCopy) {
            result.push(str);
        }
        return result;
    }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
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
