package com.leiqjl;

/**
 * 1695. Maximum Erasure Value - Medium
 */
public class MaximumErasureValue {
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^4
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] exist = new boolean[10001];
        int max = 0, sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (exist[nums[r]]) {
                sum -= nums[l];
                exist[nums[l++]] = false;
            } else {
                sum += nums[r];
                max = Math.max(sum, max);
                exist[nums[r++]] = true;
            }
        }
        return max;
    }
}
