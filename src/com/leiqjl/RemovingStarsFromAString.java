package com.leiqjl;

/**
 * 2390. Removing Stars From a String - Medium
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * - Choose a star in s.
 * - Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 */
public class RemovingStarsFromAString {
    public String removeStars(String s) {
        int idx = 0;
        char[] chars = new char[s.length()];
        for (char c : s.toCharArray()) {
            if (c == '*') {
                idx--;
            } else {
                chars[idx++] = c;
            }
        }
        return new String(chars, 0, idx);
    }

    public static void main(String[] args) {
        RemovingStarsFromAString r = new RemovingStarsFromAString();
        assert r.removeStars("leet**cod*e").equals("lecoe");
        assert r.removeStars("erase*****").equals("");
    }
}
