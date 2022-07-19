package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074. Number of Submatrices That Sum to Target - Hard
 */
public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                map.clear();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum = sum + matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    count = count + map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSubmatricesThatSumToTarget n = new NumberOfSubmatricesThatSumToTarget();

        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        assert n.numSubmatrixSumTarget(matrix, 0) == 4;

        int[][] matrix1 = {{1, -1}, {-1, 1}};
        assert n.numSubmatrixSumTarget(matrix1, 0) == 5;

        int[][] matrix2 = {{904}};
        assert n.numSubmatrixSumTarget(matrix2, 0) == 0;
    }
}
