package com.leiqjl;

/**
 * 430. Flatten a Multilevel Doubly Linked List - Medium
 */
public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        while (node != null) {
            if (node.child == null) {
                node = node.next;
                continue;
            }
            Node tmp = node.child;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node.next;
            if (node.next != null) {
                node.next.prev = tmp;
            }
            node.next = node.child;
            node.next.prev = node;
            node.child = null;
        }
        return head;
    }
}

