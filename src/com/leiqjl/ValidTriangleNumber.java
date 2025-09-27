package com.leiqjl;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number - Medium
 * Given an integer array nums, return the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber v = new ValidTriangleNumber();
        assert v.triangleNumber(new int[]{2, 2, 3, 4}) == 3;
        assert v.triangleNumber(new int[]{4, 2, 3, 4}) == 4;
    }
}
