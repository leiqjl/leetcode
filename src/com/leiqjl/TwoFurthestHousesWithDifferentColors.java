package com.leiqjl;

/**
 * 2078. Two Furthest Houses With Different Colors - Easy
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 * There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
 * <p>
 * Return the maximum distance between two houses with different colors.
 * <p>
 * The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
 */
public class TwoFurthestHousesWithDifferentColors {
    //n == colors.length
    //2 <= n <= 100
    //0 <= colors[i] <= 100
    //Test data are generated such that at least two houses have different colors.
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int len = n - 1;
        while (len > 0) {
            if (colors[0] != colors[len] || colors[n - 1] != colors[n - 1 - len]) {
                return len;
            }
            len--;
        }
        return -1;
    }

    public static void main(String[] args) {
        TwoFurthestHousesWithDifferentColors t = new TwoFurthestHousesWithDifferentColors();
        //Input: colors = [1,8,3,8,3]
        //Output: 4
        assert t.maxDistance(new int[]{1, 8, 3, 8, 3}) == 4;
        //Input: colors = [0,1]
        //Output: 1
        assert t.maxDistance(new int[]{0, 1}) == 1;
        //[4,4,4,11,4,4,11,4,4,4,4,4]
        //8
        assert t.maxDistance(new int[]{4, 4, 4, 11, 4, 4, 11, 4, 4, 4, 4, 4}) == 8;
    }
}
