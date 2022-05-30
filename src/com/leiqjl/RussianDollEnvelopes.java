package com.leiqjl;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes - Hard
 */
public class RussianDollEnvelopes {
    //Longest Increasing Subsequence
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (envelop1, envelop2) -> {
            if (envelop1[0] == envelop2[0]) {
                return Integer.compare(envelop2[1], envelop1[1]);
            } else {
                return Integer.compare(envelop1[0], envelop2[0]);
            }
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[count - 1]) {
                dp[count++] = envelopes[i][1];
            } else {
                int index = binarySearch(dp, 0, count - 1, envelopes[i][1]);
                dp[index] = envelopes[i][1];
            }
        }
        return count;
    }

    private int binarySearch(int[] a, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = a[mid];

            if (midVal < target)
                left = mid + 1;
            else if (midVal > target)
                right = mid - 1;
            else
                return mid;
        }
        return left;
    }

    //1 <= envelopes.length <= 105
    //envelopes[i].length == 2
    //1 <= wi, hi <= 105
    public static void main(String[] args) {
        RussianDollEnvelopes r = new RussianDollEnvelopes();
        //Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
        //Output: 3
        //Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        assert r.maxEnvelopes(envelopes) == 3;
        //Input: envelopes = [[1,1],[1,1],[1,1]]
        //Output: 1
        int[][] envelopes1 = {{1, 1}, {1, 1}, {1, 1}};
        assert r.maxEnvelopes(envelopes1) == 1;
    }
}
