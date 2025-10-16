package com.leiqjl;

/**
 * 2598. Smallest Missing Non-negative Integer After Operations - Medium
 * You are given a 0-indexed integer array nums and an integer value.
 * <p>
 * In one operation, you can add or subtract value from any element of nums.
 * <p>
 * · For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].
 * The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.
 * <p>
 * · For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.
 * Return the maximum MEX of nums after applying the mentioned operation any number of times.
 */
public class SmallestMissingNonNegativeIntegerAfterOperations {

    //Constraints:
    //
    //1 <= nums.length, value <= 10^5
    //-10^9 <= nums[i] <= 10^9
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];
        for (int num : nums) {
            num %= value;
            if (num < 0) {
                num += value;
            }
            count[num]++;
        }
        int minIndex = 0;
        for (int i = 1; i < value; i++) {
            if (count[i] < count[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex + count[minIndex] * value;
    }

    public static void main(String[] args) {
        SmallestMissingNonNegativeIntegerAfterOperations s = new SmallestMissingNonNegativeIntegerAfterOperations();
        assert s.findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5) == 4;
        assert s.findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7) == 2;
        assert s.findSmallestInteger(new int[]{3, 0, 3, 2, 4, 2, 1, 1, 0, 4}, 5) == 10;
    }
}
