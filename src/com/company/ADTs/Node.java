package com.company.ADTs;

import java.util.Collection;

public class Node {
    private Node next;
    private Integer data;

    public Node() {}

    public Node(Integer d) {
        data = d;
    }

    public void append(Integer d) {
        Node n = new Node(d);
        if (next == null) {
            next = n;
        } else {
            Node tail = next;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = n;
        }
    }

    public void addValues(Collection<Integer> c) {
        for (Integer i : c) {
            append(i);
        }
    }

    public void addValues(Integer[] c) {
        for (Integer i : c) {
            append(i);
        }
    }

    public void removeValue(Integer d) {
        Node head = this;
        Node tail = this.next;
        while (tail != null) {
            if (tail.data.equals(d)) {
                head.next = tail.next;
                tail = tail.next;
            } else {
                head = tail;
                tail = tail.next;
            }
        }
    }

    public String toString() {
        String s = String.format("{ %d", data);
        if (next != null) {
            for (Node tail = next; tail != null; tail = tail.next) {
                s += String.format(", %d", tail.data);
            }
        }
        s += " }";
        return s;
    }

    public boolean isEmpty() {
        return next != null;
    }

    /*
     *
     * Functional Programming Patterns
     *
     */

    public interface MapFn {
        public Integer call(Integer x);
    }

    public interface Predicate {
        public boolean call(Integer x);
    }

    public interface Reducer {
        public Integer call(Integer x, Integer y);
    }

    public Node map(MapFn fn) {
        Node newHead = new Node();
        Node tail = next;
        while (tail != null) {
            newHead.append(fn.call(tail.data));
            tail = tail.next;
        }
        return newHead;
    }

    public Node filter(Predicate p) {
        Node newHead = new Node();
        Node tail = next;
        while (tail != null) {
            if (p.call(tail.data)) {
                newHead.append(tail.data);
            }
            tail = tail.next;
        }
        return newHead;
    }

}
