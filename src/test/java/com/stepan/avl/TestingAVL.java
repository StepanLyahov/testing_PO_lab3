package com.stepan.avl;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestingAVL {

    @Test
    public void testConstructorNode() {
        Node node = new Node(1, 1, null);

        int h = node.h;
        int balance = node.balance;
        int key = node.key;
        int value = node.value;
        Node left = node.left;
        Node right = node.right;
        Node father = node.father;

        assertEquals(h, 1);
        assertEquals(balance, 0);
        assertEquals(key, 1);
        assertEquals(value, 1);
        assertNull(left);
        assertNull(right);
        assertNull(father);
    }

    @Test
    public void testHeightAVL() {
        AVL avl = new AVL();

        Node node1 = new Node(1, 1, null);
        Node node2 = new Node(2, 2, null);

        assertEquals(avl.height(node1, node2), 1);

        node1.h = 3;
        assertEquals(avl.height(node1, node2), 3);

        assertEquals(avl.height(null, null), 0);

        assertEquals(avl.height(node1, null), 3);

        assertEquals(avl.height(null, node2), 1);
    }

    @Test
    public void testBalanceAVL() {
        AVL avl = new AVL();

        Node node1 = new Node(1, 1, null);
        Node node2 = new Node(2, 2, null);

        assertEquals(avl.balance(node1, node2), 0);

        node1.h = 3;
        assertEquals(avl.balance(node1, node2), 2);

        assertEquals(avl.balance(null, null), 0);

        assertEquals(avl.balance(node1, null), 3);

        assertEquals(avl.balance(null, node2), -1);
    }

    @Test
    public void testJustAddAVL() {
        AVL avl = new AVL();

        Node root = avl.justAdd(null, 2, 2, null);
        assertNotNull(root);

        root = avl.justAdd(root, 3, 3, null);
        assertEquals(root.right.key, 3);

        root = avl.justAdd(root, 1, 1, null);
        assertEquals(root.left.key, 1);

        root = avl.justAdd(root, 1, 1, null);
        assertEquals(root.left.key, 1);

        root = avl.justAdd(root, 0, 0, null);
        assertEquals(root.left.left.key, 0);
    }

    @Test
    public void testLeftRotationAVL() {
        AVL avl = new AVL();

        Node root = avl.justAdd(null, 1, 1, null);
        root = avl.justAdd(root, 2, 2, null);
        root = avl.justAdd(root, 3, 3, null);

        root = avl.leftRotation(root);

        assertEquals(root.key, 2);
        assertEquals(root.left.key, 1);
        assertEquals(root.right.key, 3);
    }

    @Test
    public void testRightRotationAVL() {
        AVL avl = new AVL();

        Node root = avl.justAdd(null, 3, 3, null);
        root = avl.justAdd(root, 2, 2, null);
        root = avl.justAdd(root, 1, 1, null);

        root = avl.rightRotation(root);

        assertEquals(root.key, 2);
        assertEquals(root.left.key, 1);
        assertEquals(root.right.key, 3);
    }

    @Test
    public void testAddAPIAVL() {
        AVL avl = new AVL();
        avl.add(1, 1);
        avl.add(2, 2);
        avl.add(3, 3);
        avl.add(4, 4);
        avl.add(5, 5);
        avl.add(6, 6);
        avl.add(7, 7);

        Node node = avl.root;
        assertEquals(node.key, 4);

        Node leftRoot = node.left;
        assertEquals(leftRoot.key, 2);
        assertEquals(leftRoot.left.key, 1);
        assertEquals(leftRoot.right.key, 3);

        Node rightRoot = node.right;
        assertEquals(rightRoot.key, 6);
        assertEquals(rightRoot.left.key, 5);
        assertEquals(rightRoot.right.key, 7);
    }

    @Test
    public void testApiGetAVL() {
        AVL avl = new AVL();
        avl.add(1, 1);
        avl.add(2, 2);
        avl.add(3, 3);
        avl.add(4, 4);
        avl.add(5, 5);
        avl.add(6, 6);
        avl.add(7, 7);

        int res = avl.get(5);
        assertEquals(res, 5);

        res = avl.get(1);
        assertEquals(res, 1);
    }

    @Test
    public void testMinAVL() {
        AVL avl = new AVL();
        avl.add(1, 1);
        avl.add(2, 2);
        avl.add(3, 3);
        avl.add(4, 4);
        avl.add(5, 5);
        avl.add(6, 6);
        avl.add(7, 7);

        int res = avl.min(avl.root).value;
        assertEquals(res, 1);
    }

    @Test
    public void testApiDeleteAVL() {
        AVL avl = new AVL();
        avl.add(1, 1);
        avl.add(2, 2);
        avl.add(3, 3);
        avl.add(4, 4);
        avl.add(5, 5);
        avl.add(6, 6);
        avl.add(7, 7);

        avl.delete(4);

        Node node = avl.root;
        assertEquals(node.key, 5);

        Node leftRoot = node.left;
        assertEquals(leftRoot.key, 2);
        assertEquals(leftRoot.left.key, 1);
        assertEquals(leftRoot.right.key, 3);

        Node rightRoot = node.right;
        assertEquals(rightRoot.key, 6);
        assertNull(rightRoot.left);
        assertEquals(rightRoot.right.key, 7);
    }
}
