package com.leiqjl;

/**
 * 1049. Last Stone Weight II - Medium
 * <p>
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * <p>
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together.
 * Suppose the stones have weights x and y with x <= y. The result of this smash is:
 * <p>
 * - If x == y, both stones are destroyed, and
 * - If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * <p>
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 */
public class LastStoneWeightII {
    //1 <= stones.length <= 30
    //1 <= stones[i] <= 100

    //knapsack problem
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
            for (int i = Math.min(1500, sum); i >= stone; i--) {
                dp[i] |= dp[i - stone];
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeightII l = new LastStoneWeightII();
        //Input: stones = [2,7,4,1,8,1]
        //Output: 1
        assert l.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}) == 1;
        //Input: stones = [31,26,33,21,40]
        //Output: 5
        assert l.lastStoneWeightII(new int[]{31, 26, 33, 21, 40}) == 5;
    }
}
