package com.leiqjl;

import java.util.Arrays;

/**
 * 826. Most Profit Assigning Work - Medium
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDiff = Arrays.stream(worker).max().getAsInt();
        int[] dp = new int[maxDiff + 1];
        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= maxDiff) {
                dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
            }
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        int maxProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            maxProfit += dp[worker[i]];
        }
        return maxProfit;
    }

    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        // Find maximum ability in the worker array.
        int maxAbility = Arrays.stream(worker).max().getAsInt();
        int[] jobs = new int[maxAbility + 1];

        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= maxAbility) {
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
            }
        }

        // Take maxima of prefixes.
        for (int i = 1; i <= maxAbility; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }

        int netProfit = 0;
        for (int ability : worker) {
            netProfit += jobs[ability];
        }
        return netProfit;
    }
}
