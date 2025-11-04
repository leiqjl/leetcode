package com.leiqjl;

/**
 * 2257. Count Unguarded Cells in the Grid - Medium
 * You are given two integers m and n representing a 0-indexed m x n grid.
 * You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
 *
 * A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
 *
 * Return the number of unoccupied cells that are not guarded.
 */
public class CountUnguardedCellsInTheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int count = m * n - guards.length - walls.length;
        int[][] visited = new int[m][n];
        for (int[] wall : walls) {
            visited[wall[0]][wall[1]] = 3;
        }
        for (int[] guard : guards) {
            visited[guard[0]][guard[1]] = 2;
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            // 遍历四个方向
            for (int[] dir : dirs) {
                count = markDirection(visited, x, y, dir[0], dir[1], m, n, count);
            }
        }
        return count;
    }

    private int markDirection(int[][] visited, int x, int y, int dx, int dy, int m, int n, int count) {
        int nx = x + dx;
        int ny = y + dy;
        while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
            if (visited[nx][ny] > 1) {
                break;
            }
            if (visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                count--;
            }
            nx += dx;
            ny += dy;
        }
        return count;
    }

    public static void main(String[] args) {
        CountUnguardedCellsInTheGrid c = new CountUnguardedCellsInTheGrid();
        //Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
        //Output: 7
        assert c.countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}) == 7;
        //Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
        //Output: 4
        assert c.countUnguarded(3, 3, new int[][]{{1, 1}}, new int[][]{{0, 1}, {1, 0}, {2, 1}, {1, 2}}) == 4;
        //m=2,n=7,guards = [[1,5],[1,1],[1,6],[0,2]],walls = [[0,6],[0,3],[0,5]]
        //Output: 1
        assert c.countUnguarded(2, 7, new int[][]{{1, 5}, {1, 1}, {1, 6}, {0, 2}}, new int[][]{{0, 6}, {0, 3}, {0, 5}}) == 1;
        assert c.countUnguarded(5, 1, new int[][]{{0, 0}}, new int[][]{{1, 0}}) == 3;
    }
}
