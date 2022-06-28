package com.leiqjl;

/**
 * 55. Jump Game - Medium
 * You are given an integer array nums.
 * You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        //Input: nums = [2,3,1,1,4]
        //Output: true
        //Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
        int[] nums = {2, 3, 1, 1, 4};
        assert j.canJump(nums);
        //Input: nums = [3,2,1,0,4]
        //Output: false
        //Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
        int[] nums1 = {3, 2, 1, 0, 4};
        assert !j.canJump(nums1);
    }
}
