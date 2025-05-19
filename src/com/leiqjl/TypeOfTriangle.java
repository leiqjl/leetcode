package com.leiqjl;

import java.util.Arrays;

/**
 * 3024. Type of Triangle - Easy
 */
public class TypeOfTriangle {

    //none equilateral isosceles scalene
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        if (nums[0] == nums[2]) {
            return "equilateral";
        }
        if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        }
        return "scalene";
    }
}
