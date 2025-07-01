package com.leiqjl;

/**
 * 3330. Find the Original Typed String I - Easy
 */
public class FindTheOriginalTypedStringI {
    public int possibleStringCount(String word) {
        int ans = 1;
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                ans += count;
                count = 0;
            }
        }
        ans += count;
        return ans;
    }
}
