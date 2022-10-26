package com.leiqjl;

/**
 * 143. Reorder List - Medium
 * <p>
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {
    //1-2-3-4-5
    //1-5-2-4-3
    //1-2-3-4
    //1-4-2-3
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        //1-2-3-4(cur)-5(next) 1-2-3-5-4
        ListNode cur = slow.next;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = mid.next;
            mid.next = next;
        }
        slow = head;
        fast = mid.next;
        while (slow != mid) {
            mid.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = mid.next;
        }
    }

}
