package com.leiqjl;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * <p>
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * <p>
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input:nums = (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode curr = first;
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {
            int a = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            int b = 0;
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            sum = a + b + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return first.next;
    }
}
