package com.leiqjl;

/**
 * 330. Patching Array - Hard
 */
public class PatchingArray {
    //Constraints:
    //
    //1 <= nums.length <= 1000
    //1 <= nums[i] <= 104
    //nums is sorted in ascending order.
    //1 <= n <= 2^31 - 1
    public int minPatches(int[] nums, int n) {
        long cur = 1;
        int idx = 0, count = 0;
        while (cur <= n) {
            if (idx < nums.length && nums[idx] <= cur) {
                cur += nums[idx];
                idx++;
            } else {
                cur += cur;
                count++;
            }
        }
        return count;
    }
}
