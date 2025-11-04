package com.leiqjl;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 3217. Delete Nodes From Linked List Present in Array - Medium
 * You are given an array of integers nums and the head of a linked list.
 * Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
 */
public class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
