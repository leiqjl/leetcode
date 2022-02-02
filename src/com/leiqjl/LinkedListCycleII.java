package com.leiqjl;

/**
 * 142.Linked List Cycle II
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) {
                break;
            }
        }
        if (p == null || p.next == null) {
            return null;
        }
        q = head;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

}
