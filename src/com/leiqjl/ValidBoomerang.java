package com.leiqjl;

/**
 * 1037. Valid Boomerang - Easy
 */
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        return (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]) != (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]);
    }
}
