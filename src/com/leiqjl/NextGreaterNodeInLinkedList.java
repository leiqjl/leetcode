package com.leiqjl;

import java.util.*;

/**
 * 1019. Next Greater Node In Linked List - medium
 * You are given the head of a linked list with n nodes.
 * <p>
 * For each node in the list, find the value of the next greater node.
 * That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
 * <p>
 * Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed).
 * If the ith node does not have a next greater node, set answer[i] = 0.
 */
public class NextGreaterNodeInLinkedList {

    //Constraints:
    //
    //The number of nodes in the list is n.
    //1 <= n <= 10^4
    //1 <= Node.val <= 10^9
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            while (!deque.isEmpty() && val > list.get(deque.peek())) {
                result[deque.pop()] = val;
            }
            deque.push(i);
        }
        return result;
    }
    public int[] nextLargerNodes1(ListNode head) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<int[]> deque = new ArrayDeque<>();
        while (head != null) {
            count++;
            while (!deque.isEmpty() && head.val > deque.peek()[1]) {
                map.put(deque.peek()[0], head.val);
                deque.pop();
            }
            deque.push(new int[]{count, head.val});
            head = head.next;
        }
        while (!deque.isEmpty()) {
            map.put(deque.peek()[0], 0);
            deque.pop();
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = map.get(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList n = new NextGreaterNodeInLinkedList();
        //Input: head = [2,1,5]
        //Output: [5,5,0]
        ListNode head = ListNode.build(new int[]{2,1,5});
        assert "[5, 5, 0]".equals(Arrays.toString(n.nextLargerNodes(head)));
        //Input: head = [2,7,4,3,5]
        //Output: [7,0,5,5,0]
        head = ListNode.build(new int[]{2,7,4,3,5});
        assert "[7, 0, 5, 5, 0]".equals(Arrays.toString(n.nextLargerNodes(head)));
    }
}
