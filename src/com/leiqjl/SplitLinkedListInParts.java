package com.leiqjl;

/**
 * 725. Split Linked List in Parts - Medium
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }
        int size = n / k;
        int remain = n % k;
        node = head;
        for (int i = 0; i < k; i++) {
            res[i] = node;
            int s = size;
            while (s > 1) {
                node = node.next;
                s--;
            }
            if (size > 0 && remain > 0) {
                node = node.next;
                remain--;
            }
            if (node == null) {
                break;
            }
            ListNode tmp = node;
            node = node.next;
            tmp.next = null;
        }
        return res;
    }
}
