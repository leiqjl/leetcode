package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2553. Separate the Digits in an Array - Easy
 * Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.
 * <p>
 * To separate the digits of an integer is to get all the digits it has in the same order.
 * <p>
 * For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
 */
public class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (nums[i] > 0) {
                list.add(nums[i] % 10);
                nums[i] /= 10;
            }
        }
        int n = list.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = list.get(n - 1 - i);
        }
        return answer;
    }
}
