package com.leiqjl;

/**
 * 2074. Reverse Nodes in Even Length Groups
 */
public class ReverseNodesInEvenLengthGroups {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode cur = head;
        int n = 2;
        while (cur != null && cur.next != null) {
            ListNode temp = cur;
            for (int i = 0; i < n; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    n = i;
                    break;
                }
            }
            if (n % 2 != 0)
                cur = temp;
            else {
                cur = reverse(cur, n);
            }
            n++;
        }
        return head;
    }

    private ListNode reverse(ListNode head, int c) {
        ListNode tail = head.next;
        ListNode prev = null;
        ListNode cur = head.next;
        ListNode next;

        for (int i = 0; i < c; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = prev;
        tail.next = cur;
        return tail;
    }


}
