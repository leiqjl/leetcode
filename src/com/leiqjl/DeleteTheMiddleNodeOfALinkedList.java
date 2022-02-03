package com.leiqjl;

/**
 * 2095. Delete the Middle Node of a Linked List
 *
 * 
 */
public class DeleteTheMiddleNodeOfALinkedList {

    /**
     * @see MiddleOfTheLinkedList#middleNode(ListNode)
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
