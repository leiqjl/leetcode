package com.leiqjl;

/**
 * 2000. Reverse Prefix of Word - Easy
 */
public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int idx = word.indexOf(ch);
        if (idx <= 0) {
            return word;
        }
        int l = 0, r = idx;
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
        return new String(chars);
    }
}
