package com.leiqjl;

/**
 * 1910. Remove All Occurrences of a Substring - Medium
 * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
 * <p>
 * ·Find the leftmost occurrence of the substring part and remove it from s.
 * Return s after removing all occurrences of part.
 * <p>
 * A substring is a contiguous sequence of characters in a string.
 */
public class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        char[] charArray = s.toCharArray();
        int idx = 0;
        int n = part.length();
        for (int i = 0; i < charArray.length; i++) {
            charArray[idx] = charArray[i];
            if (idx >= n - 1 && check(charArray, idx, part)) {
                idx -= n;
            }
            idx++;
        }
        return new String(charArray, 0, idx);
    }

    private boolean check(char[] charArray, int idx, String part) {
        for (int i = idx, j = part.length() - 1; j >= 0; i--, j--) {
            if (charArray[i] != part.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RemoveAllOccurrencesOfASubstring r = new RemoveAllOccurrencesOfASubstring();
        assert r.removeOccurrences("daabcbaabcbc", "abc").equals("dab");
        assert r.removeOccurrences("axxxxyyyyb", "xy").equals("ab");
        assert r.removeOccurrences("eemckxmckx", "emckx").equals("");
    }
}
