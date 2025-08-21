package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1504. Count Submatrices With All Ones - Medium
 */
public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] h = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                h[j] = mat[i][j] == 0 ? 0 : h[j] + 1;
            }
            Deque<int[]> stack = new ArrayDeque<>();
            stack.push(new int[]{-1, -1, 0});
            for (int j = 0; j < n; j++) {
                int height = h[j];
                while (stack.peek()[1] >= height) {
                    stack.pop();
                }
                int prevIdx = stack.peek()[0];
                int prevNum = stack.peek()[2];
                int curNum = prevNum + (j - prevIdx) * height;
                stack.push(new int[]{j, height, curNum});
                count += curNum;
            }
        }
        return count;
    }
}
