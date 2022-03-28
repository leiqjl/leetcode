package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues - Easy
 */
public class ImplementStackUsingQueues {
    //push O(1) pop O(n)
    class MyStack {
        Queue<Integer> q;
        int top;

        public MyStack() {
            q = new ArrayDeque<>();
        }

        public void push(int x) {
            q.offer(x);
            top = x;
        }

        public int pop() {

            int size = q.size();
            while (size > 2) {
                q.offer(q.poll());
                size--;
            }
            top = q.peek();
            q.offer(q.poll());
            return q.poll();
        }

        public int top() {
            if (q.isEmpty()) {
                return -1;
            }
            return top;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    //push O(n) pop O(1)
    class MyStack1 {
        Queue<Integer> q;

        public MyStack1() {
            q = new ArrayDeque<>();
        }

        public void push(int x) {
            q.offer(x);
            int i = q.size() - 1;
            while (i-- > 0) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

}
