package com.leiqjl;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2130. Maximum Twin Sum of a Linked List
 *
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node,
 * if 0 <= i <= (n / 2) - 1.
 *
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 *
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
public class MaximumTwinSumOfALinkedList {

    public int pairSum(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = reverse(slow);
        int sum = 0;
        while (reverseHead != null) {
            sum = Math.max(sum, reverseHead.val + head.val);
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return sum;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //stack
    //time O(N) space O(N)
    public int pairSum1(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            deque.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        int sum = 0;
        while (slow != null) {
            sum = Math.max(sum, slow.val + deque.pop().val);
            slow = slow.next;
        }
        return sum;
    }

}
