package com.company.ADTs;

import java.util.HashMap;

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

    private HashMap<String, Node> hash;
    private Node first;
    private Node last;
    private int maxLen;
    private int N;

    public LRUCache(int maxLen) {
        this.maxLen = maxLen;
        this.hash = new HashMap<>(maxLen);
    }

    public void save(String key, T item) {
        Node node = new Node(key, item);
        hash.put(key, node);
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
            hash.remove(last.key);
            last = last.prev;
            last.next.prev = null;
            last.next = null;
            N--;
        }
    }

    public void moveToFront(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = first;
        first.prev = node;
        first = node;
    }

    public T get(String key) {
        if (!hash.containsKey(key)) {
            return null;
        }
        Node node = hash.get(key);
        moveToFront(node);
        return node.item;
    }
}
