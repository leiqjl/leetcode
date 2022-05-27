package com.leiqjl;

/**
 * 322. Coin Change - Medium
 */
public class CoinChange {

    //1 <= coins.length <= 12
    //1 <= coins[i] <= 231 - 1
    //0 <= amount <= 104
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        int curAmount = 1;
        while (curAmount <= amount) {
            int count = -1;
            for (int coin : coins) {
                if (curAmount >= coin && dp[curAmount - coin] != -1) {
                    int temp = dp[curAmount - coin] + 1;
                    if (count == -1 || temp < count) {
                        count = temp;
                    }
                }
            }
            dp[curAmount++] = count;
        }
        return dp[amount];
    }

}
