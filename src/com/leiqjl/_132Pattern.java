package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 456. 132 Pattern - Medium
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 * <p>
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 */
public class _132Pattern {
    //i < j < k
    // nums[i] < nums[k] < nums[j].
    public boolean find132pattern1(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int s3 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                s3 = Math.max(s3, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        int idx = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }
            while (idx < nums.length && nums[i] > nums[idx]) {
                s3 = Math.max(s3, nums[idx++]);
            }
            nums[--idx] = nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        _132Pattern t = new _132Pattern();
        //Input: nums = [1,2,3,4]
        //Output: false
        int[] nums = {1, 2, 3, 4};
        assert !t.find132pattern(nums);
        //Input: nums = [3,1,4,2]
        //Output: true
        int[] nums1 = {3, 1, 4, 2};
        assert t.find132pattern(nums1);
        //Input: nums = [-1,3,2,0]
        //Output: true
        int[] nums2 = {-1, 3, 2, 0};
        assert t.find132pattern(nums2);
    }
}
