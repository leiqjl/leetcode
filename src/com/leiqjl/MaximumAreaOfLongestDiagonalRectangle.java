package com.leiqjl;

/**
 * 3000. Maximum Area of Longest Diagonal Rectangle - Easy
 */
public class MaximumAreaOfLongestDiagonalRectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        int d = 0;
        for (int[] dimension : dimensions) {
            int x = dimension[0];
            int y = dimension[1];
            int temp = x * x + y * y;
            int tempArea = x * y;
            if (temp> d) {
                d = temp;
                area = tempArea;
            } else if (temp == d) {
                area = Math.max(tempArea, area);
            }
        }
        return area;
    }
}
