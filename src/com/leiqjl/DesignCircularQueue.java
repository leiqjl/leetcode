package com.leiqjl;

/**
 * 622. Design Circular Queue - Medium
 */
public class DesignCircularQueue {
    class MyCircularQueue {
        int[] arr;
        int front = 0;
        int last = -1;
        int size = 0;

        public MyCircularQueue(int k) {
            arr = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            last = (last + 1) % arr.length;
            arr[last] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % arr.length;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[last];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == arr.length;
        }
    }
}
