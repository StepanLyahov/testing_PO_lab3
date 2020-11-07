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

        Node root = avl.justAdd(null, 2,2, null);
        assertNotNull(root);

        root = avl.justAdd(root, 3,3, null);
        assertEquals(root.right.key, 3);

        root = avl.justAdd(root, 1,1, null);
        assertEquals(root.left.key, 1);

        root = avl.justAdd(root, 1,1, null);
        assertEquals(root.left.key, 1);

        root = avl.justAdd(root, 0,0, null);
        assertEquals(root.left.left.key, 0);
    }
}
