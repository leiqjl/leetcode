package com.leiqjl;

import java.util.*;

/**
 * 133. Clone Graph - Medium
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(node);

        HashMap<Integer, Node> hashMap = new HashMap<>();
        Node cloneNode = new Node(node.val);
        hashMap.put(node.val, cloneNode);

        while (!deque.isEmpty()) {
            Node poll = deque.poll();
            for (Node neighbor : poll.neighbors) {
                if (!hashMap.containsKey(neighbor.val)) {
                    hashMap.put(neighbor.val, new Node(neighbor.val));
                    deque.offer(neighbor);
                }
                hashMap.get(poll.val).neighbors.add(hashMap.get(neighbor.val));
            }
        }
        return cloneNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

