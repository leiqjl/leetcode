package com.leiqjl;

/**
 * 1128. Number of Equivalent Domino Pairs - Easy
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int answer = 0;
        int[] freq = new int[100];
        for (int[] d : dominoes) {
            int key;
            if (d[0] <= d[1]) {
                key = d[0] * 10 + d[1];
            } else {
                key = d[1] * 10 + d[0];
            }
            answer += freq[key];
            freq[key]++;
        }
        return answer;
    }
}
