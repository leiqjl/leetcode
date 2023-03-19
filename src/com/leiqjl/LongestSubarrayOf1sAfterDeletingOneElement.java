package com.leiqjl;

/**
 * 1493. Longest Subarray of 1's After Deleting One Element - Medium
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray1(int[] nums) {
        int max = 0;
        int l = 0, r = 0, idx = -1;
        while (r < nums.length) {
            if (nums[r] == 0) {
                l = idx + 1;
                idx = r;
            }
            max = Math.max(max, r - l);
            r++;
        }
        return max;
    }

    public int longestSubarray(int[] nums) {
        int max = 0, count = 0, prevCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, prevCount + count);
                prevCount = count;
                count = 0;
            }
        }
        max = Math.max(max, prevCount + count);
        return max == nums.length ? max - 1 : max;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement l = new LongestSubarrayOf1sAfterDeletingOneElement();
        assert l.longestSubarray(new int[]{1, 1, 0, 1}) == 3;
        assert l.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}) == 5;
        assert l.longestSubarray(new int[]{1, 1, 1}) == 2;
    }

}
