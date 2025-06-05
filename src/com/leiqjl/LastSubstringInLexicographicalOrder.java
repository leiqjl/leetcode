package com.leiqjl;

/**
 * 1163. Last Substring in Lexicographical Order - Hard
 */
public class LastSubstringInLexicographicalOrder {
    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                i = Math.max(i + k + 1, j);
                j = i + 1;
            } else {
                j = j  + k + 1;
            }
        }
        return s.substring(i);
    }
}
