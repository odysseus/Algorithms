package com.company.ADTs;



public class LinkedList {

    Node first;
    Node last;
    int length;

    private class Node<T> {
        T item;
        Node next;
        Node prev;
    }

}
