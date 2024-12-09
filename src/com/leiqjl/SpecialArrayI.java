package com.leiqjl;

/**
 * 3151. Special Array I - Easy
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 * <p>
 * You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
 */
public class SpecialArrayI {
    public boolean isArraySpecial(int[] nums) {
        boolean isOdd = (nums[0] & 1) == 1;
        for (int i = 1; i < nums.length; i++) {
            if (((nums[i] & 1) == 1) == isOdd) {
                return false;
            } else {
                isOdd = !isOdd;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SpecialArrayI s = new SpecialArrayI();
        assert s.isArraySpecial(new int[]{1});
        assert s.isArraySpecial(new int[]{2, 1, 4});
        assert !s.isArraySpecial(new int[]{4, 3, 1, 6});
    }
}
