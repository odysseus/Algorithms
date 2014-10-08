package com.company.Streams;

import java.util.HashMap;

public class RunningMedian {
    private class Node {
        private Double value;
        private Long tally;
        private Node next;
        private Node prev;

        private Node(Double v) {
            value = v;
            tally = 1L;
        }
    }

    private Long count;
    private HashMap<Double, Node> tallies;
    private Node head;

    public RunningMedian() {
        count = 0L;
        tallies = new HashMap<>(8);
    }

    public void input(Double value) {
        if (tallies.containsKey(value)) {
            Node n = tallies.get(value);
            n.tally++;
        } else {
            Node n = new Node(value);
            // Hash the node
            tallies.put(value, n);
            // Then add it to the LinkedList
            if (head == null) {
                head = n;
            } else {
                Node test = head;
                while (test.value < n.value && test.next != null) {
                    test = test.next;
                }
                Node next = test.next;
                test.next = n;
                n.prev = test;
                n.next = next;
                if (next != null) {
                    next.prev = n;
                }
            }
        }
        count++;
    }

    public Double getMedian() throws UnsupportedOperationException {
        if (head == null) {
            throw new UnsupportedOperationException("No numbers have been added, use input() to add new numbers");
        }
        long medianIndex = count / 2;
        long currentIndex = 0;
        Node currentNode = head;
        if (medianIndex == 0) {
            return head.value;
        }
        while (currentIndex < medianIndex) {
            currentIndex += currentNode.tally;
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

}
