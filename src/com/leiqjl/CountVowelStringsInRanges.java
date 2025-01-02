package com.leiqjl;

import java.util.Arrays;

/**
 * 2559. Count Vowel Strings in Ranges - Medium
 */
public class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if ("aeiou".indexOf(words[i].charAt(0)) >= 0 && "aeiou".indexOf(words[i].charAt(words[i].length() - 1)) >= 0) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }
        return result;
    }

    public static void main(String[] args) {
        CountVowelStringsInRanges c = new CountVowelStringsInRanges();
        //Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
        //Output: [2,3,0]
        //Explanation:
        assert Arrays.equals(c.vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{{0, 2}, {1, 4}, {1, 1}}), new int[]{2, 3, 0});
        //For query [0,2], "aba" and "ece" contain vowels "a" and "e",
        //but "bcb" does not contain vowel 'e'.
        //For query [1,4], "bcb", "ece", "aa" and "e" contain vowel 'e'.
        assert Arrays.equals(c.vowelStrings(new String[]{"a", "e", "i"}, new int[][]{{0, 2}, {0, 1}, {2, 2}}), new int[]{3, 2, 1});
    }
}
