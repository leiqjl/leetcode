package com.leiqjl;

/**
 * 3289. The Two Sneaky Numbers of Digitville - Easy
 * In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1.
 * Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time, making the list longer than usual.
 * <p>
 * As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order),
 * so peace can return to Digitville.
 */
public class TheTwoSneakyNumbersOfDigitville {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        for (int i = 0; i < n; i++) {
            x ^= i;
        }
        //x = a ^ b
        int lowBit = x & -x;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & lowBit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i & lowBit) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
