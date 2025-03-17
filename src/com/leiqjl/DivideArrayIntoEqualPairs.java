package com.leiqjl;

/**
 * 2206. Divide Array Into Equal Pairs - Easy
 * You are given an integer array nums consisting of 2 * n integers.
 * <p>
 * You need to divide nums into n pairs such that:
 * <p>
 * ·Each element belongs to exactly one pair.
 * ·The elements present in a pair are equal.
 * Return true if nums can be divided into n pairs, otherwise return false
 */
public class DivideArrayIntoEqualPairs {
    //Constraints:
    //
    //nums.length == 2 * n
    //1 <= n <= 500
    //1 <= nums[i] <= 500
    public boolean divideArray1(int[] nums) {
        int[] count = new int[501];
        for (int num : nums) {
            count[num]++;
        }
        for (int c : count) {
            if (c % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    //2,2,4,1,5
    //1^4=5
    public boolean divideArray(int[] nums) {
        int xor1 = 0, xor2 = 0;
        for (int num : nums) {
            xor1 = xor1 ^ num;
            xor2 = xor2 ^ (num + 1);
        }
        return xor1 == 0 && xor2 == 0;
    }


    public static void main(String[] args) {
        DivideArrayIntoEqualPairs d = new DivideArrayIntoEqualPairs();
        assert d.divideArray(new int[]{3, 2, 3, 2, 2, 2});
        assert !d.divideArray(new int[]{1, 2, 3, 4});
        assert !d.divideArray(new int[]{500, 500, 500, 500, 499, 499, 20, 52});
        assert !d.divideArray(new int[]{9, 9, 19, 10, 9, 12, 2, 12, 3, 3, 11, 5, 8, 4, 13, 6, 2, 11, 9, 19, 11, 15, 9, 17, 15, 12, 5, 14, 12, 16, 18, 16, 10, 3, 8, 9, 16, 20, 2, 4, 16, 12, 11, 14, 20, 16, 2, 18, 17, 20, 3, 13, 16, 17, 1, 1, 11, 20, 20, 4});
    }
}
