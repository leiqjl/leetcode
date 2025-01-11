package com.leiqjl;

/**
 * 1400. Construct K Palindrome Strings - Medium
 */
public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        if (s.length() == k) {
            return true;
        }
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int odds = 0;
        for (int count : counts) {
            if ((count & 1) == 1) {
                odds++;
            }
        }
        return odds <= k;
    }

    public static void main(String[] args) {
        ConstructKPalindromeStrings c = new ConstructKPalindromeStrings();
        assert c.canConstruct("annabelle", 2);
        assert !c.canConstruct("leetcode", 3);
        assert c.canConstruct("true", 4);
        assert c.canConstruct("qlkzenwmmnpkopu", 15);
    }
}
