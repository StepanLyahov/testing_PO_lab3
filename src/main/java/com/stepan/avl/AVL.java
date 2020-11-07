package com.stepan.avl;

public class AVL {
    public Node root;

    public int height(Node x, Node y) {
        if (x == null && y == null) return 0;
        else if (x == null) return y.h;
        else if (y == null) return x.h;
        else return Math.max(x.h, y.h);
    }

    public int balance(Node x, Node y) {
        if (x == null && y == null) return 0;
        else if (x == null) return -y.h;
        else if (y == null) return x.h;
        else return x.h - y.h;
    }

    public Node justAdd(Node node, Integer key, Integer value, Node father) {
        if (node == null) {
            Node newnode = new Node(key, value, father);
            return newnode;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = justAdd(node.right, key, value, node);
            node.h = height(node.left, node.right) + 1;
        } else if (compareResult < 0) {
            node.left = justAdd(node.left, key, value, node);
            node.h = height(node.left, node.right) + 1;
        } else {
            node.value = value;
        }
        return node;
    }
}
