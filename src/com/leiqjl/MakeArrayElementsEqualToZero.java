package com.leiqjl;

/**
 * 3354. Make Array Elements Equal to Zero - Easy
 * You are given an integer array nums.
 * <p>
 * Start by selecting a starting position curr such that nums[curr] == 0, and choose a movement direction of either left or right.
 * <p>
 * After that, you repeat the following process:
 * <p>
 * ·If curr is out of the range [0, n - 1], this process ends.
 * ·If nums[curr] == 0, move in the current direction by incrementing curr if you are moving right, or decrementing curr if you are moving left.
 * ·Else if nums[curr] > 0:
 * ·Decrement nums[curr] by 1.
 * ·Reverse your movement direction (left becomes right and vice versa).
 * ·Take a step in your new direction.
 * A selection of the initial position curr and movement direction is considered valid if every element in nums becomes 0 by the end of the process.
 * <p>
 * Return the number of possible valid selections.
 */
public class MakeArrayElementsEqualToZero {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        for (int num : nums) {
            leftSum += num;
        }
        int rightSum = 0;
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                if (leftSum >= rightSum && leftSum - rightSum <= 1) {
                    answer++;
                }
                if (rightSum >= leftSum && rightSum - leftSum <= 1) {
                    answer++;
                }
            } else {
                leftSum -= nums[i];
                rightSum += nums[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MakeArrayElementsEqualToZero m = new MakeArrayElementsEqualToZero();
        assert m.countValidSelections(new int[]{1, 0, 2, 0, 3}) == 2;
        assert m.countValidSelections(new int[]{2, 3, 4, 0, 4, 1, 0}) == 0;
        assert m.countValidSelections(new int[]{16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7}) == 3;
        assert m.countValidSelections(new int[]{0}) == 2;
    }
}
