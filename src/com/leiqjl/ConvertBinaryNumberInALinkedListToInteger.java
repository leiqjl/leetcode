package com.leiqjl;

/**
 * 1290. Convert Binary Number in a Linked List to Integer - Easy
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int val = 0;
        while (head != null) {
            val = (val << 1) + head.val;
            head = head.next;
        }
        return val;
    }
}
