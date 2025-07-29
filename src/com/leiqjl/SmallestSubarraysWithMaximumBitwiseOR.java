package com.leiqjl;

import java.util.Arrays;

/**
 * 2411. Smallest Subarrays With Maximum Bitwise OR - Medium
 */
public class SmallestSubarraysWithMaximumBitwiseOR {
    //Constraints:
    //
    //n == nums.length
    //1 <= n <= 10^5
    //0 <= nums[i] <= 10^9
    public int[] smallestSubarrays(int[] nums) {
        int[] bitPos = new int[31];
        Arrays.fill(bitPos, -1);
        int[] ans = new int[nums.length];
        for (int l = nums.length - 1; l >= 0; l--) {
            int r = l;
            for (int bit = 0; bit < 31; bit++) {
                if ((nums[l] & (1 << bit)) == 0) {
                    if (bitPos[bit] != -1) {
                        r = Math.max(r, bitPos[bit]);
                    }
                } else {
                    bitPos[bit] = l;
                }
            }
            ans[l] = r - l + 1;
        }
        return ans;
    }
}
