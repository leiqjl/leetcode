package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 3583. Count Special Triplets - Medium
 */
public class CountSpecialTriplets {

    // i < j < k  nums[i] = nums[j] * 2 = nums[k]
    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007;
        int ans = 0;
        Map<Integer, Integer> map1 = new HashMap<>();// i
        Map<Integer, Integer> map2 = new HashMap<>();// (i,j)
        for (int num : nums) {
            if ((num & 1) == 0) {
                ans = (ans + map2.getOrDefault(num / 2, 0)) % mod;
            }
            map2.put(num, (map2.getOrDefault(num, 0) + map1.getOrDefault(num * 2, 0)) % mod);
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        return ans;
    }

}
