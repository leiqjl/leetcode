package com.leiqjl;

import java.util.Arrays;

/**
 * 1626. Best Team With No Conflicts - Medium
 */
public class BestTeamWithNoConflicts {
    //Constraints:
    //
    //1 <= scores.length, ages.length <= 1000
    //scores.length == ages.length
    //1 <= scores[i] <= 10^6
    //1 <= ages[i] <= 1000
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] ageScorePair = new int[n][2];
        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }
        Arrays.sort(ageScorePair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = ageScorePair[i][1];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ageScorePair[i][1] >= ageScorePair[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + ageScorePair[i][1]);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }


    public static void main(String[] args) {
        BestTeamWithNoConflicts b = new BestTeamWithNoConflicts();
        //Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
        //Output: 34
        assert b.bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}) == 34;
        //Input: scores = [4,5,6,5], ages = [2,1,2,1]
        //Output: 16
        assert b.bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}) == 16;
        //Input: scores = [1,2,3,5], ages = [8,9,10,1]
        //Output: 6
        assert b.bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}) == 6;
    }
}
