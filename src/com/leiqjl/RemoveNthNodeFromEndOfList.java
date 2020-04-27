package com.leiqjl;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndOfList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode quick = node;

        while (n>0 && quick.next != null) {
            quick = quick.next;
            n--;
        }
        if (n == 1) {
            return head.next;
        }
        if (n != 0) {
            return head;
        }

        while (quick.next != null) {
            quick = quick.next;
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}
