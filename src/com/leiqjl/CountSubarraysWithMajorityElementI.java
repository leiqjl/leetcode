package com.leiqjl;

/**
 * 3737. Count Subarrays With Majority Element I - Medium
 * You are given an integer array nums and an integer target.
 * <p>
 * Return the number of subarrays of nums in which target is the majority element.
 * <p>
 * The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.
 */
public class CountSubarraysWithMajorityElementI {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                cnt += (nums[j] == target ? 1 : -1);
                if (cnt > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubarraysWithMajorityElementI c = new CountSubarraysWithMajorityElementI();
        assert c.countMajoritySubarrays(new int[]{1, 2, 2, 3}, 2) == 5;
        assert c.countMajoritySubarrays(new int[]{1, 1, 1, 1}, 1) == 10;
        assert c.countMajoritySubarrays(new int[]{1, 2, 3}, 4) == 0;
    }
}
