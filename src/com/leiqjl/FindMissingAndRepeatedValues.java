package com.leiqjl;

import java.util.Arrays;


/**
 * 2965. Find Missing and Repeated Values - Easy
 * You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n^2].
 * Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.
 * <p>
 * Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.
 */
public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int index = 1;
        int sumDiff = 0, sqrDiff = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                sumDiff += (num - index);
                sqrDiff += (num * num - index * index);
                index++;
            }
        }
        // x-y = sumDiff
        // (x + y) * (x - y) = sqrDiff
        int x = (sumDiff + sqrDiff / sumDiff) / 2;
        int y = x - sumDiff;
        return new int[]{x, y};
    }

    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        int n = grid.length;
        boolean[] seen = new boolean[n * n + 1];
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (seen[num]) {
                    result[0] = num;
                }
                seen[num] = true;
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (!seen[i]) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues f = new FindMissingAndRepeatedValues();
        //Example 1:
        //
        //Input: grid = [[1,3],[2,2]]
        //Output: [2,4]
        //Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
        //Example 2:
        //
        //Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
        //Output: [9,5]
        //Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
        assert Arrays.toString(f.findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})).equals("[2, 4]");
        assert Arrays.toString(f.findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}})).equals("[9, 5]");

    }
}
