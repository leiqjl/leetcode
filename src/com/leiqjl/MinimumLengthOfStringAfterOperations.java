package com.leiqjl;

/**
 * 3223. Minimum Length of String After Operations - Medium
 * You are given a string s.
 * <p>
 * You can perform the following process on s any number of times:
 * <p>
 * Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
 * · Delete the closest character to the left of index i that is equal to s[i].
 * · Delete the closest character to the right of index i that is equal to s[i].
 * Return the minimum length of the final string s that you can achieve.
 */
public class MinimumLengthOfStringAfterOperations {
    public int minimumLength(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int length = 0;
        for (int i = 0; i < 26; i++) {
            int count = counts[i];
            if (count == 0) {
                continue;
            }
            length = length + ((count & 1) == 1 ? 1 : 2);
        }
        return length;
    }

    public static void main(String[] args) {
        MinimumLengthOfStringAfterOperations m = new MinimumLengthOfStringAfterOperations();
        assert m.minimumLength("abaacbcbb") == 5;
        assert m.minimumLength("aa") == 2;
        assert m.minimumLength("ca") == 2;
    }
}
