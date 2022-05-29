package com.leiqjl;

/**
 * 318. Maximum Product of Word Lengths - Medium
 */
public class MaximumProductOfWordLengths {

    //2 <= words.length <= 1000
    //1 <= words[i].length <= 1000
    //words[i] consists only of lowercase English letters.
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                bits[i] |= (1 << (c-'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {

            for (int j = i+1; j < words.length; j++) {
                if ((bits[i] & bits[j]) != 0) {
                    continue;
                }
                max = Math.max(words[i].length()* words[j].length(), max);
            }

        }
        return max;
    }
}
