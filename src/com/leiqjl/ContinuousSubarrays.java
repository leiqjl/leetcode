package com.leiqjl;

/**
 * 2762. Continuous Subarrays - Medium
 */
public class ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        long result = 0;
        int left = 0, right = 0;
        int min = nums[right], max = nums[right];
        while (right < nums.length) {
            min = Math.min(nums[right], min);
            max = Math.max(nums[right], max);
            if (max - min > 2) {
                long len = right - left;
                result = result + ((len + 1) * len / 2);

                left = right;
                min = max = nums[right];
                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    min = Math.min(min, nums[left]);
                    max = Math.max(max, nums[left]);
                }
                if (left != right) {
                    len = right - left;
                    result = result - ((len + 1) * len / 2);
                }
            }
            right++;
        }
        long len = right - left;
        result = result + ((len + 1) * len / 2);
        return result;
    }

}
