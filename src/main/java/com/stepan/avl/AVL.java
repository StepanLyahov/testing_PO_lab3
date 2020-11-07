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

    public Node leftRotation(Node node) {
        if (node.right.right == null && node.right.left != null) {
            node.right = rightRotation(node.right);
            node = leftRotation(node);
        } else if (node.right.left == null || node.right.left.h <= node.right.right.h) {
            Node newnode = node.right;
            newnode.father = node.father;
            node.right = newnode.left;
            if (node.right != null)
                node.right.father = node;
            node.h = height(node.left, node.right) + 1;
            node.father = newnode;
            node.balance = balance(node.left, node.right);
            newnode.left = node;
            node = newnode;
            node.balance = balance(node.left, node.right);
            node.h = height(node.left, node.right) + 1;
        } else {
            node.right = rightRotation(node.right);
            node = leftRotation(node);
        }
        return node;
    }

    public Node rightRotation(Node nodeAVL) {
        if (nodeAVL.left.right != null && nodeAVL.left.left == null) {
            nodeAVL.left = leftRotation(nodeAVL.left);
            nodeAVL = rightRotation(nodeAVL);
        } else if (nodeAVL.left.right == null || nodeAVL.left.right.h <= nodeAVL.left.left.h) {
            Node newnode = nodeAVL.left;
            newnode.father = nodeAVL.father;
            nodeAVL.left = newnode.right;
            if (nodeAVL.left != null)
                nodeAVL.left.father = nodeAVL;
            nodeAVL.h = height(nodeAVL.left, nodeAVL.right) + 1;
            nodeAVL.father = newnode;
            nodeAVL.balance = balance(nodeAVL.left, nodeAVL.right);
            newnode.right = nodeAVL;
            nodeAVL = newnode;
            nodeAVL.balance = balance(nodeAVL.left, nodeAVL.right);
            nodeAVL.h = height(nodeAVL.left, nodeAVL.right) + 1;
        } else {
            nodeAVL.left = leftRotation(nodeAVL.left);
            nodeAVL = rightRotation(nodeAVL);
        }
        return nodeAVL;
    }

    public Node balancing(Node node) {
        node.balance = balance(node.left, node.right);
        if (node.balance == -2) {
            node = leftRotation(node);
        } else if (node.balance == 2) {
            node = rightRotation(node);
        }
        return node;
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

    public Node add(Node node, Integer key, Integer value, Node father) {
        if (node == null) {
            Node newnode = new Node(key, value, father);
            return newnode;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = add(node.right, key, value, node);
            node.h = height(node.left, node.right) + 1;
        } else if (compareResult < 0) {
            node.left = add(node.left, key, value, node);
            node.h = height(node.left, node.right) + 1;
        } else {
            node.value = value;
        }
        node.balance = balance(node.left, node.right);
        if (node.balance == -2) {
            node = leftRotation(node);
        } else if (node.balance == 2) {
            node = rightRotation(node);
        }
        return node;
    }

    //интерфейс
    public void add(Integer key, Integer value) {
        root = add(root, key, value, null);
    }

    public Integer get(Node nodeAVL, Integer key) {
        if (nodeAVL == null) return null;
        int compareResult = key.compareTo(nodeAVL.key);
        if (compareResult == 0) {
            return nodeAVL.value;
        } else if (compareResult > 0) {
            return get(nodeAVL.right, key);
        } else {
            return get(nodeAVL.left, key);
        }
    }

    // интерфейс
    public Integer get(Integer key) {
        return get(root, key);
    }

    public Node min(Node nodeAVL) {
        if (nodeAVL.left == null) return nodeAVL;
        return min(nodeAVL.left);
    }

}
