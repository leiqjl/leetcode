package com.leiqjl;

/**
 * 2483. Minimum Penalty for a Shop - Medium
 */
public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        char[] chars = customers.toCharArray();
        int n = customers.length();
        int lN = 0, rY = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'N') {
                lN++;
            }
        }
        int minTime = n, minPenalty = lN;
        while (--n >= 0) {
            if (chars[n] == 'Y') {
                rY++;
            } else {
                lN--;
            }
            int penalty = lN + rY;
            if (penalty <= minPenalty) {
                minPenalty = penalty;
                minTime = n;
            }
        }
        return minTime;
    }

    public static void main(String[] args) {
        MinimumPenaltyForAShop m = new MinimumPenaltyForAShop();
        assert m.bestClosingTime("YYNY") == 2;
        assert m.bestClosingTime("NNNNN") == 0;
        assert m.bestClosingTime("YYYY") == 4;

    }
}
