package com.leiqjl;

/**
 * 300. Longest Increasing Subsequence - Medium
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len++] = nums[i];
            } else {
                int index = binarySearch(dp, 0, len - 1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] a, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = a[mid];

            if (midVal < target)
                left = mid + 1;
            else if (midVal > target)
                right = mid - 1;
            else
                return mid;
        }
        return left;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        //Input: nums = [10,9,2,5,3,7,101,18]
        //Output: 4
        //Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(l.lengthOfLIS(nums));
        //Input: nums = [0,1,0,3,2,3]
        //Output: 4
        int[] nums1 = {0, 1, 0, 3, 2, 3};
        System.out.println(l.lengthOfLIS(nums1));
        //Input: nums = [7,7,7,7,7,7,7]
        //Output: 1
        int[] nums2 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(l.lengthOfLIS(nums2));
        //Input: nums = [10,9,2,5,3,4]
        //Output: 3
        int[] nums3 = {10, 9, 2, 5, 3, 4};
        System.out.println(l.lengthOfLIS(nums3));
    }
}
