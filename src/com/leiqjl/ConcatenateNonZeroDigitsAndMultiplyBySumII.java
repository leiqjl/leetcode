package com.leiqjl;

import java.util.Arrays;

/**
 * 3756. Concatenate Non-Zero Digits and Multiply by Sum II - Medium
 * You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].
 * <p>
 * For each queries[i], extract the substring s[li..ri]. Then, perform the following:
 * <p>
 * Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
 * Let sum be the sum of digits in x. The answer is x * sum.
 * Return an array of integers answer where answer[i] is the answer to the ith query.
 * <p>
 * Since the answers may be very large, return them modulo 10^9 + 7.
 */
public class ConcatenateNonZeroDigitsAndMultiplyBySumII {
    //Constraints:
    //
    //1 <= m == s.length <= 10^5
    //s consists of digits only.
    //1 <= queries.length <= 10^5
    //queries[i] = [li, ri]
    //0 <= li <= ri < m
    private static final int MOD = 1000000007;
    private static final long[] pow = new long[100001];

    static {
        pow[0] = 1;
        for (int i = 1; i < 100001; i++)
            pow[i] = pow[i - 1] * 10L % MOD;
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] x = new long[n + 1];
        int[] sum = new int[n + 1];
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            sum[i + 1] = sum[i] + d;
            if (d > 0) {
                x[i + 1] = (x[i] * 10 + d) % MOD;
                count[i + 1] = count[i] + 1;
            } else {
                x[i + 1] = x[i];
                count[i + 1] = count[i];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0], ri = queries[i][1];
            int len = count[ri + 1] - count[li];
            long curX = (x[ri + 1] - ((x[li] * pow[len]) % MOD) + MOD) % MOD;
            res[i] = (int) (curX * (sum[ri + 1] - sum[li]) % MOD);
        }
        return res;
    }


    public static void main(String[] args) {
        ConcatenateNonZeroDigitsAndMultiplyBySumII c = new ConcatenateNonZeroDigitsAndMultiplyBySumII();
        //Input: s = "10203004", queries = [[0,7],[1,3],[4,6]]
        //Output: [12340, 4, 9]
        assert Arrays.equals(c.sumAndMultiply("10203004", new int[][]{{0, 7}}), new int[]{12340});
        //Input: s = "1000", queries = [[0,3],[1,1]]
        //Output: [1, 0]
        assert Arrays.equals(c.sumAndMultiply("1000", new int[][]{{0, 3}, {1, 1}}), new int[]{1, 0});
        //Input: s = "9876543210", queries = [[0,9]]
        //Output: [444444137]
        assert Arrays.equals(c.sumAndMultiply("9876543210", new int[][]{{0, 9}}), new int[]{444444137});
    }
}
