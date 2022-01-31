package com.leiqjl;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    //time O(Nlogk)
    //space O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummyHead = new ListNode(-1);
        ListNode n = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(x -> x.val));
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {

            n.next = pq.poll();
            n = n.next;
            if (n.next != null) {
                pq.add(n.next);
            }
        }
        return dummyHead.next;
    }
}

