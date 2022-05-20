package com.leiqjl;

/**
 * 63. Unique Paths II - Medium
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i - 1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j - 1] == 1 && obstacleGrid[0][j] == 0) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : (obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]);
            }
        }
        return obstacleGrid[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePathsII u = new UniquePathsII();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assert u.uniquePathsWithObstacles(obstacleGrid) == 2;
        int[][] obstacleGrid1 = {{0, 1}, {0, 0}};
        assert u.uniquePathsWithObstacles(obstacleGrid1) == 1;
        int[][] obstacleGrid2 = {{0, 0}, {0, 1}};
        assert u.uniquePathsWithObstacles(obstacleGrid2) == 0;
    }
}
