package com.leiqjl;

/**
 * 837. New 21 Game - Medium
 * Alice plays the following game, loosely based on the card game "21".
 * <p>
 * Alice starts with 0 points and draws numbers while she has less than k points.
 * During each draw, she gains an integer number of points randomly from the range [1, maxPts],
 * where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.
 * <p>
 * Alice stops drawing numbers when she gets k or more points.
 * <p>
 * Return the probability that Alice has n or fewer points.
 * <p>
 * Answers within 10-5 of the actual answer are considered accepted.
 */
public class New21Game {
    //Constraints:
    //
    //0 <= k <= n <= 10^4
    //1 <= maxPts <= 10^4
    // p(k) = p(k-1)/maxPts + p(k-2)/maxPts + ... + p(k-maxPts)/maxPts
    //pSum = p(k-1) + p(k-2) + ... + p(k-maxPts)
    //p(k) = pSum / maxPts
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1;
        }
        double[] dp = new double[n + 1];
        double res = 0, pSum = 1;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = pSum / maxPts;
            if (i < k) {
                pSum += dp[i];
            } else {
                res += dp[i];
            }
            if (i >= maxPts) {
                pSum -= dp[i - maxPts];
            }
        }
        return res;
    }

}
