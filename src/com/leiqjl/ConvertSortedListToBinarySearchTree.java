package com.leiqjl;

/**
 * 109. Convert Sorted List to Binary Search Tree - Medium
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return convert(head, null);
    }

    private TreeNode convert(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head, slow = fast;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = convert(head, slow);
        root.right = convert(slow.next, tail);
        return root;
    }
}
