package com.leiqjl;

/**
 * 378. Kth Smallest Element in a Sorted Matrix - Medium
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low <= high) {
            int midVal = (low + high) / 2;
            int count = less(matrix, midVal);
            if (count < k) {
                low = midVal + 1;
            } else {
                high = midVal - 1;
            }
        }
        return low;
    }

    private int less(int[][] matrix, int val) {
        int count = 0;
        int n = matrix.length;
        int x = n - 1, y = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] > val) {
                x--;
            } else {
                count = count + x + 1;
                y++;
            }
        }
        return count;
    }
}
