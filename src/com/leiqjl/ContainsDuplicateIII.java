package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 220. Contains Duplicate III - Hard
 * <p>
 * You are given an integer array nums and two integers indexDiff and valueDiff.
 * <p>
 * Find a pair of indices (i, j) such that:
 * <p>
 * ·i != j,
 * ·abs(i - j) <= indexDiff.
 * ·abs(nums[i] - nums[j]) <= valueDiff, and
 * Return true if such pair exists or false otherwise.
 */
public class ContainsDuplicateIII {
    //Constraints:
    //
    //2 <= nums.length <= 10^5
    //-10^9 <= nums[i] <= 10^9
    //1 <= indexDiff <= nums.length
    //0 <= valueDiff <= 10^9
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int min = -(int) Math.pow(10, 9);
        Map<Integer, Integer> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] - min;
            int key = val / (valueDiff + 1);
            if (buckets.containsKey(key)
                    || (buckets.containsKey(key - 1) && val - buckets.get(key - 1) <= valueDiff)
                    || (buckets.containsKey(key + 1) && buckets.get(key + 1) - val <= valueDiff)) {
                return true;
            }
            if (i >= indexDiff) {
                buckets.remove((nums[i - indexDiff] - min) / (valueDiff + 1));
            }
            buckets.put(key, val);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII c = new ContainsDuplicateIII();
        assert c.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
        assert !c.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }
}
