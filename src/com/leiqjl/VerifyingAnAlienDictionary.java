package com.leiqjl;

/**
 * 953. Verifying an Alien Dictionary - Easy
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] idx = new int[26];
        for (int i = 0; i < 26; i++) {
            idx[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], idx) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String w1, String w2, int[] idx) {
        int len1 = w1.length();
        int len2 = w2.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            int idx1 = idx[w1.charAt(i) - 'a'];
            int idx2 = idx[w2.charAt(i) - 'a'];
            if (idx1 != idx2) {
                return idx1 - idx2;
            }
        }
        return len1 - len2;
    }
}
