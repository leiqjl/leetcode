package com.leiqjl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 909. Snakes and Ladders - Medium
 */
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int cur = queue.poll();
                if (visited[cur]) {
                    continue;
                }
                visited[cur] = true;
                if (cur == n * n) {
                    return count;
                }
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    if (next > n * n) {
                        break;
                    }
                    int boardVal = getBoardValue(board, next);
                    if (boardVal > 0) {
                        next = boardVal;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int i) {
        int n = board.length;
        int r = (i - 1) / n;
        int row = n - r - 1;
        int col = r % 2 == 0 ? i - r * n - 1 : (r + 1) * n - i;
        return board[row][col];
    }

    public static void main(String[] args) {
        SnakesAndLadders s = new SnakesAndLadders();
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        assert s.snakesAndLadders(board) == 4;
        int[][] board1 = {{-1, -1}, {-1, 3}};
        assert s.snakesAndLadders(board1) == 1;
    }
}
