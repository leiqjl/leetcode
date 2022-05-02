package com.leiqjl;

/**
 * 905. Sort Array By Parity - Easy
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            while (begin < end && nums[begin] % 2 == 0) {
                begin++;
            }
            while (begin < end && nums[end] % 2 == 1) {
                end--;
            }
            if (begin < end) {
                int tmp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = tmp;
            }
        }
        return nums;
    }
}
