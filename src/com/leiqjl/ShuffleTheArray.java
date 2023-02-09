package com.leiqjl;

import java.util.Arrays;

/**
 * 1470. Shuffle the Array - Easy
 */
public class ShuffleTheArray {
    //1 <= n <= 500
    //nums.length == 2n
    //1 <= nums[i] <= 10^3    1024
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] << 10) | nums[i + n];
        }
        int mask = (1 << 10) - 1;
        for (int i = n - 1; i >= 0; i--) {
            nums[i * 2 + 1] = nums[i] & mask;
            nums[i * 2] = nums[i] >>> 10;
        }
        return nums;
    }

    public static void main(String[] args) {
        ShuffleTheArray s = new ShuffleTheArray();
        int[] nums = {2,5,1,3,4,7};
        assert "[2, 3, 5, 4, 1, 7]".equals(Arrays.toString(s.shuffle(nums, 3)));
    }
}
