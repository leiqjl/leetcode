package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2487. Remove Nodes From Linked List - Medium
 */
public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode listNode = head;
        while (listNode != null) {
            deque.push(listNode);
            listNode = listNode.next;
        }
        ListNode newHead = deque.pop();
        while (!deque.isEmpty()) {
            ListNode pop = deque.pop();
            if (pop.val >= newHead.val) {
                pop.next = newHead;
                newHead = pop;
            }
        }
        return newHead;
    }


}
