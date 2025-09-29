package com.leiqjl;

/**
 * 1039. Minimum Score Triangulation of Polygon - Medium
 */
public class MinimumScoreTriangulationOfPolygon {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        MinimumScoreTriangulationOfPolygon m = new MinimumScoreTriangulationOfPolygon();
        //Input: values = [1,2,3]
        //Output: 6
        assert m.minScoreTriangulation(new int[]{1, 2, 3}) == 6;
        //Input: values = [3,7,4,5]
        //Output: 144
        assert m.minScoreTriangulation(new int[]{3, 7, 4, 5}) == 144;
        //Input: values = [1,3,1,4,1,5]
        //Output: 13
        assert m.minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}) == 13;
    }
}
