package com.leiqjl;

import java.util.Random;

/**
 * 382. Linked List Random Node - Medium
 */
public class LinkedListRandomNode {
    //Reservoir Sampling
    class Solution {
        ListNode head;
        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int i = 1, val = 0;
            ListNode node = head;
            Random random = new Random();
            while (node != null) {
                if (random.nextInt(i) == 0) {
                    val = node.val;
                }
                node = node.next;
                i++;
            }
            return val;
        }
    }
}
