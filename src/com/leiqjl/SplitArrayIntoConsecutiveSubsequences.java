package com.leiqjl;

/**
 * 659. Split Array into Consecutive Subsequences - Medium
 * <p>
 * You are given an integer array nums that is sorted in non-decreasing order.
 * <p>
 * Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:
 * <p>
 * - Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
 * - All subsequences have a length of 3 or more.
 * <p>
 * Return true if you can split nums according to the above conditions, or false otherwise.
 * <p>
 * A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without
 * disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).
 */
public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        int preLen1 = 0, preLen2 = 0, preLen3 = 0;
        int curLen1 = 0, curLen2 = 0, curLen3 = 0;
        int pre = Integer.MIN_VALUE, cur;
        int i = 0;
        while (i < nums.length) {
            int count = 0;
            for (cur = nums[i]; i < nums.length && cur == nums[i]; i++) {
                count++;
            }
            if (pre == cur - 1) {
                if (count < preLen1 + preLen2) {
                    return false;
                }
                curLen1 = Math.max(0, count - preLen1 - preLen2 - preLen3);
                curLen2 = preLen1;
                curLen3 = preLen2 + Math.min(preLen3, count - preLen1 - preLen2);
            } else {
                if (preLen1 != 0 || preLen2 != 0) {
                    return false;
                }
                curLen1 = count;
                curLen2 = 0;
                curLen3 = 0;
            }
            preLen1 = curLen1;
            preLen2 = curLen2;
            preLen3 = curLen3;
            pre = cur;
        }
        return preLen1 == 0 && preLen2 == 0;
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences s = new SplitArrayIntoConsecutiveSubsequences();
        //Input: nums = [1,2,3,3,4,5]
        //Output: true
        //Explanation: nums can be split into the following subsequences:
        //[1,2,3,3,4,5] --> 1, 2, 3
        //[1,2,3,3,4,5] --> 3, 4, 5
        int[] nums = {1, 2, 3, 3, 4, 5};
        assert s.isPossible(nums);
        //Input: nums = [1,2,3,3,4,4,5,5]
        //Output: true
        //Explanation: nums can be split into the following subsequences:
        //[1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
        //[1,2,3,3,4,4,5,5] --> 3, 4, 5
        int[] nums1 = {1, 2, 3, 3, 4, 4, 5, 5};
        assert s.isPossible(nums1);
        //Input: nums = [1,2,3,4,4,5]
        //Output: false
        //Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
        int[] nums2 = {1, 2, 3, 4, 4, 5};
        assert !s.isPossible(nums2);
    }
}
