package com.leiqjl;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int i = 1;
        int j = 2;
        int total = 0;
        while (n >= 3) {
            total = i + j;
            i = j;
            j = total;
            n--;
        }
        return total;
    }
}
