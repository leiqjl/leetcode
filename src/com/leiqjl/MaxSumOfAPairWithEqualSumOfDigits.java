package com.leiqjl;

/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits - Medium
 * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
 * <p>
 * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
 */
public class MaxSumOfAPairWithEqualSumOfDigits {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^9
    public int maximumSum(int[] nums) {
        int maxSum = -1;
        int[] sums = new int[82];
        for (int num : nums) {
            int sum = sumOfDigits(num);
            if (sums[sum] > 0) {
                maxSum = Math.max(maxSum, sums[sum] + num);
            }
            sums[sum] = Math.max(sums[sum], num);
        }
        return maxSum;
    }

    private int sumOfDigits(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num = num / 10;
        }
        return digitSum;
    }

    public static void main(String[] args) {
        MaxSumOfAPairWithEqualSumOfDigits m = new MaxSumOfAPairWithEqualSumOfDigits();
        assert m.maximumSum(new int[]{18, 43, 36, 13, 7}) == 54;
        assert m.maximumSum(new int[]{10, 12, 19, 14}) == -1;
        assert m.maximumSum(new int[]{229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401}) == 973;
    }
}
