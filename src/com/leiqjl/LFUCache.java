package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU Cache - Hard
 */
public class LFUCache {
    class Node {
        int key;
        int val;
        int freq = 1;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleLinkedList {
        Node head, tail;
        int size;

        DoubleLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            } else {
                return null;
            }
        }
    }

    int capacity;
    int count = 0;
    int minFreq = 0;
    Map<Integer, Node> cacheMap = new HashMap<>();

    Map<Integer, DoubleLinkedList> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToNextFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Node node = cacheMap.get(key);
        if (node == null) {
            count++;
            if (count > capacity) {
                DoubleLinkedList doubleLinkedList = freqMap.get(minFreq);
                Node minFreqNode = doubleLinkedList.removeLast();
                cacheMap.remove(minFreqNode.key);
                count--;
            }
            node = new Node(key, value);
            cacheMap.put(key, node);
            this.addNode(node);
            minFreq = 1;
        } else {
            node.val = value;
            this.moveToNextFreq(node);
        }
    }

    private void moveToNextFreq(Node node) {
        this.removeNode(node);
        node.freq++;
        this.addNode(node);
    }

    private void addNode(Node node) {
        int freq = node.freq;
        DoubleLinkedList doubleLinkedList = freqMap.computeIfAbsent(freq, x -> new DoubleLinkedList());
        doubleLinkedList.add(node);
    }

    private void removeNode(Node node) {
        int freq = node.freq;
        DoubleLinkedList doubleLinkedList = freqMap.get(node.freq);
        doubleLinkedList.remove(node);
        if (doubleLinkedList.size == 0 && freq == minFreq) {
            minFreq++;
        }
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3

        LFUCache lfuCache = new LFUCache(0);
        lfuCache.put(0, 0);
        lfuCache.get(0);
    }
}
