package com.leiqjl;

import java.util.Arrays;

/**
 * 948. Bag of Tokens - Medium
 */
public class BagOfTokens {
    //sort + greedy
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left];
                left++;
                score++;
            } else if (score > 0 && left < right) {
                power += tokens[right];
                right--;
                score--;
            } else {
                return score;
            }
        }
        return score;
    }
}
