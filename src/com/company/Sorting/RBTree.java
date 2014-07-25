package com.company.Sorting;

public class RBTree {
    private class Node {
        private int value;
        private boolean red;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        private Node() {}
        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public RBTree() {}

    public void insert(int value) {
        Node ins = new Node(value);
        ins.red = true;
        if (root == null) {
            ins.red = false;
            root = ins;
        } else {
            sink(ins, root);
        }
    }

    public void sink(Node newn, Node comp) {
        if (newn.value <= comp.value) {
            if (comp.leftChild == null) {
                comp.leftChild = newn;
                newn.parent = comp;
            } else {
                sink(newn, comp.leftChild);
            }
        } else {
            if (comp.rightChild == null) {
                comp.rightChild = newn;
                newn.parent = comp;
            } else {
                sink(newn, comp.rightChild);
            }
        }
    }
}
