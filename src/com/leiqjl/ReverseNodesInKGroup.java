package com.leiqjl;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp, cur = dummy;
        int count = 0;
        while (cur.next != null) {
            count = 0;
            temp = cur;
            for (int i = 0; i < k; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                    count++;
                } else {
                    break;
                }
            }
            if (count == k) {
                cur = reverse(cur, k);
            } else {
                break;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode tail = head.next;
        ListNode prev = null;
        ListNode cur = head.next;
        ListNode next;

        for (int i = 0; i < k; i++) {
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
