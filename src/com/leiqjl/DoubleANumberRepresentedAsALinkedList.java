package com.leiqjl;

/**
 * 2816. Double a Number Represented as a Linked List - Medium
 */
public class DoubleANumberRepresentedAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        doubleNode(dummy);
        return dummy.val == 0 ? dummy.next : dummy;
    }

    private int doubleNode(ListNode node) {
        if (node == null) {
            return 0;
        }
        int i = doubleNode(node.next);
        int sum = node.val * 2 + i;
        if (sum >= 10) {
            node.val = sum - 10;
            return 1;
        } else {
            node.val = sum;
            return 0;
        }
    }
}
