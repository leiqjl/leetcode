package com.leiqjl;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    static ListNode build(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        for (int num : nums) {
            tmp.next = new ListNode(num);
            tmp = tmp.next;
        }
        return dummy.next;
    }
}