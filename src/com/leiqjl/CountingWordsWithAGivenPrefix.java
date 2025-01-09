package com.leiqjl;

/**
 * 2185. Counting Words With a Given Prefix - Easy
 */
public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                res++;
            }
        }
        return res;
    }
}
