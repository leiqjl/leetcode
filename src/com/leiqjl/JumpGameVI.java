package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1696. Jump Game VI - Medium
 */
public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i] + nums[deque.getFirst()];
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);

            if (i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
        }
        return nums[n - 1];
    }

    //Time Limit Exceeded
    public int maxResult1(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= Math.min(n - 1, i + k); j++) {
                dp[j] = Math.max(dp[j], dp[i] + nums[j]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        JumpGameVI j = new JumpGameVI();
        //Input: nums = [1,-1,-2,4,-7,3], k = 2
        //Output: 7
        //Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
        int[] nums = {1, -1, -2, 4, -7, 3};
        assert j.maxResult(nums, 2) == 7;
        //Input: nums = [10,-5,-2,4,0,3], k = 3
        //Output: 17
        //Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
        int[] nums1 = {10, -5, -2, 4, 0, 3};
        assert j.maxResult(nums1, 3) == 17;
        //Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
        //Output: 0
        int[] nums2 = {1, -5, -20, 4, -1, 3, -6, -3};
        assert j.maxResult(nums2, 2) == 0;
    }
}
