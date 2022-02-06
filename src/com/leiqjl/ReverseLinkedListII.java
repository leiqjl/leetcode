package com.leiqjl;

/**
 * 92. Reverse Linked List II
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //1-2-3-4-5 m=2 n=4
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode next = start.next;
        //1(pre)-2(start)-3(next)-4-5 m=2 n=4
        for (int i = 0; i < n - m; i++) {
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = start.next;
        }
        return dummy.next;
    }


    //----------
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
