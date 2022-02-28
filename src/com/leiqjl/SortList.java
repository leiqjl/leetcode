package com.leiqjl;

/**
 * 148. Sort List - Medium
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        while (node1 != null) {
            p.next = node1;
            p = p.next;
            node1 = node1.next;
        }
        while (node2 != null) {
            p.next = node2;
            p = p.next;
            node2 = node2.next;
        }
        return dummyHead.next;
    }

}
