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
        ListNode fast = head;
        while (k > 0) {
            k--;
            if (fast.next != null) {
                fast = fast.next;
                count++;
            } else {
                fast = head;
                k = k % count;
            }
        }
        if (fast == head) {
            return head;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
