package com.leiqjl;

import java.util.Arrays;

/**
 * 1769. Minimum Number of Operations to Move All Balls to Each Box - Medium
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] arr = new int[n];
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + sum;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            sum += count;
        }
        count = 0;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = arr[i] + sum;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            sum += count;
        }
        return arr;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMoveAllBallsToEachBox s = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();
        assert Arrays.equals(new int[]{1, 1, 3}, s.minOperations("110"));
        assert Arrays.equals(new int[]{11, 8, 5, 4, 3, 4}, s.minOperations("001011"));
    }
}
