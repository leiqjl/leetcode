package com.leiqjl;

/**
 * 1464. Maximum Product of Two Elements in an Array - Easy
 */
public class MaximumProductOfTwoElementsInAnArray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return (max - 1) * (secondMax - 1);
    }

    public static void main(String[] args) {
        MaximumProductOfTwoElementsInAnArray m = new MaximumProductOfTwoElementsInAnArray();
        assert m.maxProduct(new int[]{10, 2, 5, 2}) == 36;
    }


}
