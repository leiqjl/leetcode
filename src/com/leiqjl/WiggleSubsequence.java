package com.leiqjl;

/**
 * 376. Wiggle Subsequence - Medium
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i - 1] > nums[i]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void main(String[] args) {
        WiggleSubsequence w = new WiggleSubsequence();
        //Input: nums = [1,7,4,9,2,5]
        //Output: 6
        //Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
        int[] nums = {1, 7, 4, 9, 2, 5};
        assert w.wiggleMaxLength(nums) == 6;
        //Input: nums = [1,17,5,10,13,15,10,5,16,8]
        //Output: 7
        //Explanation: There are several subsequences that achieve this length.
        //One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
        int[] nums1 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        assert w.wiggleMaxLength(nums1) == 7;
        //Input: nums = [1,2,3,4,5,6,7,8,9]
        //Output: 2
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assert w.wiggleMaxLength(nums2) == 2;
    }
}
