package com.leiqjl;

/**
 * 82. Remove Duplicates from Sorted List II - Medium
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
