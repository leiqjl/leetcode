package com.leiqjl;

/**
 * 160.Intersection of Two Linked Lists
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }

            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }
        return p;
    }
}
