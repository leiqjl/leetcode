package com.leiqjl;

/**
 * 1014. Best Sightseeing Pair - Medium
 */
public class BestSightseeingPair {

    // i<j  values[i] + values[j] + i - j
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        int max = values[0];
        for (int i = 1; i < values.length; i++) {

            maxScore = Math.max(maxScore, max + values[i] - i);

            max = Math.max(max, values[i] + i);

        }
        return maxScore;
    }

    public static void main(String[] args) {
        BestSightseeingPair b = new BestSightseeingPair();
        assert b.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}) == 11;
        assert b.maxScoreSightseeingPair(new int[]{1, 2}) == 2;
    }
}
