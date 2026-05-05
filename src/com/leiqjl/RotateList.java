package com.leiqjl;

/**
 * 61. Rotate List - Medium
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {

    //Input: head = [1,2,3,4,5], k = 2
    //Output: [4,5,1,2,3]
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        ListNode newTail = head;
        for (int i = 0; i < count - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

}
