package com.leiqjl;

import java.util.Arrays;

/**
 * 2294. Partition Array Such That Maximum Difference Is K - Medium
 */
public class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int min = nums[0];
        for (int num : nums) {
            if (num - min > k) {
                ans++;
                min = num;
            }
        }
        return ans;
    }
}
