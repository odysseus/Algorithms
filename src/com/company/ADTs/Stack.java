package com.company.ADTs;

public class Stack<T> {

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

}
