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
        int twoStepsBefore = 1;
        int oneStepsBefore = 2;
        int cur = 0;
        while (n >= 3) {
            cur = twoStepsBefore + oneStepsBefore;
            twoStepsBefore = oneStepsBefore;
            oneStepsBefore = cur;
            n--;
        }
        return cur;
    }
}
