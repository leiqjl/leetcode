package com.leiqjl;

import java.util.Arrays;

/**
 * 948. Bag of Tokens - Medium
 */
public class BagOfTokens {

    //Each token may be played at most once and in any order. You do not have to play all the tokens.
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int max = 0, score = 0, left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left];
                score++;
                left++;
            } else {
                if (left<right) {
                    score--;
                    power += tokens[right];
                    right--;
                } else {
                    break;
                }

            }
        }
        return max;
    }
}
