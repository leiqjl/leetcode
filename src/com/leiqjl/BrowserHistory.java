package com.leiqjl;

/**
 * 1472. Design Browser History - Medium
 */
public class BrowserHistory {
    class Node {
        String val;

        Node prev;
        Node next;

        public Node() {
        }

        public Node(String val) {
            this.val = val;
        }
    }

    private Node head, tail;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        tail = head;
    }

    public void visit(String url) {
        if (tail.next != null) {
            tail.next.prev = null;
        }
        Node node = new Node(url);
        tail.next = node;
        node.prev = tail;
        tail = tail.next;
    }

    public String back(int steps) {
        while (tail != head && steps > 0) {
            tail = tail.prev;
            steps--;
        }
        return tail.val;
    }

    public String forward(int steps) {
        while (tail.next != null && steps > 0) {
            tail = tail.next;
            steps--;
        }
        return tail.val;
    }
}
