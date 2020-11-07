package com.stepan.avl.impl;

public class Node {
    public int h;
    public int balance;
    public int key;
    public int value;
    public Node left, right, father;

    public Node(int key, int value, Node father) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
        this.father = father;
        this.h = 1;
        this.balance = 0;
    }

}
