package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3542. Minimum Operations to Convert All Elements to Zero - Medium
 */
public class MinimumOperationsToConvertAllElementsToZero {
    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            if (num == 0) {
                continue;
            }
            if (stack.isEmpty() || stack.peek() < num) {
                stack.push(num);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperationsToConvertAllElementsToZero a = new MinimumOperationsToConvertAllElementsToZero();
        assert a.minOperations(new int[]{0, 2}) == 1;
        assert a.minOperations(new int[]{3, 1, 2, 1}) == 3;
        assert a.minOperations(new int[]{1, 2, 1, 2, 1, 2}) == 4;
    }
}
