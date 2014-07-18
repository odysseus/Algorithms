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

    // Grow the cache to a new size
    // Simply involves increasing the upper bounds
    public void growTo(int maxLen) {
        this.maxLen = maxLen;
    }

    // Shrink the cache to a new size
    public void shrinkTo(int maxLen) {
        this.maxLen = maxLen;
        Node head = first;
        int count = 1;
        // Find the new final node on the LL
        while (count < maxLen) {
            if (head.next != null) {
                head = head.next;
                count++;
            } else {
                // If there aren't that many items we have nothing to drop
                return;
            }
        }
        // head is at the new final item, to remove references to the items
        // being removed we need to break the references to them from the
        // main list *and* remove each key individually from the list
        Node behead = head.next;
        head.next = null;
        behead.prev = null;
        hash.remove(behead.key);
        while (behead.next != null) {
            behead = behead.next;
            hash.remove(behead.key);
        }
    }
}
