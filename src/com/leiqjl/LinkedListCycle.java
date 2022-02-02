package com.leiqjl;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }
}
