package com.company.ADTs;

public class LRUCache<T> {
    private class Node {
        String key;
        T item;
        Node next;
        Node prev;

        public Node(String key, T item) {
            this.key = key;
            this.item = item;
        }
    }

    private Node first;
    private Node last;
    private int maxLen;
    private int N;

    public LRUCache(int maxLen) {
        this.maxLen = maxLen;
    }

    public void add(String key, T item) {
        Node node = new Node(key, item);
        if (first == null) {
            first = node;
            last = node;
            N++;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
            N++;
        }
        if (N > maxLen) {
            last = last.prev;
            last.next.prev = null;
            last.next = null;
            N--;
        }
    }

    public void moveToFront(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = first;
        first.prev = node;
        first = node;
    }

    public T access(String key) {
        Node front = first;
        while (front.next != null) {
            if (front.key.equals(key)) {
                moveToFront(front);
                return front.item;
            } else {
                front = front.next;
            }
        }
        return null;
    }
}
