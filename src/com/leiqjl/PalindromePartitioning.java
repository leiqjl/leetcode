package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning - Medium
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int l, String s, List<String> list, List<List<String>> result) {
        if (l == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int r = l; r < s.length(); r++) {
            if (isPalindrome(s, l, r)) {
                list.add(s.substring(l, r + 1));
                dfs(r + 1, s, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        assert p.partition("aab").toString().equals("[[a, a, b], [aa, b]]");
        assert p.partition("a").toString().equals("[[a]]");
    }

}
