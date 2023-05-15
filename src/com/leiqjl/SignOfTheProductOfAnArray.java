package com.leiqjl;

/**
 * 1822. Sign of the Product of an Array - Easy
 */
public class SignOfTheProductOfAnArray {
    //Constraints:
    //
    //1 <= nums.length <= 1000
    //-100 <= nums[i] <= 100
    public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                result = -result;
            }
        }
        return result;
    }
}
