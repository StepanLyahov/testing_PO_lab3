package com.stepan.avl;

public class Node {
    public int h;
    public int balance;
    public Integer key;
    public Integer value;
    public Node left, right, father;

    public Node(Integer key, Node father) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
        this.father = father;
        this.h = 1;
        this.balance = 0;
    }

}
