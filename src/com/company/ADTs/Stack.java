package com.company.ADTs;

public class Stack<T> {

    private class Node<T> {
        T item;
        Node next;
    }

    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public <T> void push(T item) {
        Node n = new Node();
        n.item = item;
        n.next = first;
        first = n;
        N++;
    }

    public <T> T pop() {
        first = first.next;
        N--;
        return (T) first.item;
    }


}