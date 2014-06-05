package com.company;

import java.util.Iterator;

// AutoResizing, LIFO stack implementation
public class StackArray<Item> implements Iterable<Item> {
    private Item[] a= (Item[]) new Object[1];
    private int N = 0;

    public StackArray(int n) {
        a = (Item[]) new Object[n];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        // Avoid lingering references, allow garbage collection
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(a, 0, temp, 0, max);
        a = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() { }
    }

}
