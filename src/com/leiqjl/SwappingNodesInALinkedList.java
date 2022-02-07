package com.leiqjl;

/**
 * 1721. Swapping Nodes in a Linked List
 * <p>
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 */
public class SwappingNodesInALinkedList {

    //The number of nodes in the list is n.
    //1 <= k <= n <= 105
    //0 <= Node.val <= 100
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p = null, q = null, tmpNode = head;
        while (tmpNode != null) {
            if (q != null) {
                q = q.next;
            }
            k--;
            if (k == 0) {
                p = tmpNode;
                q = head;
            }
            tmpNode = tmpNode.next;
        }
        int a = p.val;
        p.val = q.val;
        q.val = a;
        return head;
    }


}
