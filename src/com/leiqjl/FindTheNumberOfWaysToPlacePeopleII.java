package com.leiqjl;

import java.util.Arrays;

/**
 * 3027. Find the Number of Ways to Place People II - Hard
 */
public class FindTheNumberOfWaysToPlacePeopleII {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                if (y2 > y1) {
                    continue;
                }
                if (y2 > max) {
                    count++;
                    max = y2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindTheNumberOfWaysToPlacePeopleII f = new FindTheNumberOfWaysToPlacePeopleII();
        //Input: points = [[1,1],[2,2],[3,3]]
        //Output: 0
        assert f.numberOfPairs(new int[][]{{1, 1}, {2, 2}, {3, 3}}) == 0;
        //Input: points = [[6,2],[4,4],[2,6]]
        //Output: 2
        assert f.numberOfPairs(new int[][]{{6, 2}, {4, 4}, {2, 6}}) == 2;
        //Input: points = [[3,1],[1,3],[1,1]]
        //Output: 2
        assert f.numberOfPairs(new int[][]{{3, 1}, {1, 3}, {1, 1}}) == 2;
    }
}
