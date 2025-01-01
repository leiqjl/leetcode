package com.leiqjl;

/**
 * 1422. Maximum Score After Splitting a String - Easy
 */
public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {

        int maxDiff = Integer.MIN_VALUE, zeros = 0, ones = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeros++;
            }
            maxDiff = Math.max(maxDiff, zeros - ones);
        }
        if (s.charAt(s.length() - 1) == '1') {
            ones++;
        }
        return maxDiff + ones;
    }
}
