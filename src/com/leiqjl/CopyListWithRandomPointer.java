package com.leiqjl;

/**
 * 138. Copy List with Random Pointer - Medium
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node newHead = head.next;
        curr = head;
        Node node = curr.next;
        while (node.next != null) {
            curr.next = curr.next.next;
            curr = curr.next;
            node.next = node.next.next;
            node = node.next;
        }
        curr.next = curr.next.next;
        return newHead;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
