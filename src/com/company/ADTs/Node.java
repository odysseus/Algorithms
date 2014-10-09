package com.company.ADTs;

import java.util.Collection;

public class Node {
    private Node next;
    private Integer data;

    public Node() {}

    public Node(Integer d) {
        data = d;
    }

    public boolean isEmpty() {
        return next == null;
    }

    public void push(Integer d) {
        Node n = new Node(d);
        n.next = next;
        next = n;
    }

    public Integer pop() throws UnsupportedOperationException {
        if (isEmpty()) {
            throw new UnsupportedOperationException("List is empty - Cannot pop on an empty list");
        } else {
            Node head = next;
            next = head.next;
            return head.data;
        }
    }

    public void addValues(Collection<Integer> c) {
        for (Integer i : c) {
            push(i);
        }
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

    public void addValues(Integer[] c) {
        for (Integer i : c) {
            push(i);
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

    public Node reversed() {
        Node newHead = new Node();
        for (Node tail = next; tail != null; tail = tail.next) {
            newHead.push(tail.data);
        }
        return newHead;
    }

    /*
     *
     * Functional Programming Patterns
     * Basic map, filter and reduce functions. All of these return a new
     * list rather than mutating the current one
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
        for (Node tail = next; tail != null; tail = tail.next) {
            newHead.append(fn.call(tail.data));
        }
        return newHead;
    }

    public Node filter(Predicate p) {
        Node newHead = new Node();
        for (Node tail = next; tail != null; tail = tail.next) {
            if (p.call(tail.data)) {
                newHead.append(tail.data);
            }
        }
        return newHead;
    }

    public Integer foldl(Reducer fn) {
        Integer accum = 0;
        if (next != null) {
            accum = next.data;
            for (Node tail = next.next; tail != null; tail = tail.next) {
                accum = fn.call(accum, tail.data);
            }
        }
        return accum;
    }

    public Integer foldr(Reducer fn) {
        return reversed().foldl(fn);
    }

}
