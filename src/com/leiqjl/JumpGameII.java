package com.leiqjl;

/**
 * 45. Jump Game II - Medium
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int max = 0, lastPos = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == lastPos) {
                lastPos = max;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JumpGameII j = new JumpGameII();
        //Input: nums = [2,3,1,1,4]
        //Output: 2
        //Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        int[] nums = {2, 3, 1, 1, 4};
        assert j.jump(nums) == 2;
        //Input: nums = [2,3,0,1,4]
        //Output: 2
        int[] nums1 = {2,3,0,1,4};
        assert j.jump(nums1) == 2;
    }
}
