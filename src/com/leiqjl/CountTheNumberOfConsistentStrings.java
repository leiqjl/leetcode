package com.leiqjl;

/**
 * 1684. Count the Number of Consistent Strings - Easy
 *
 * You are given a string allowed consisting of distinct characters and an array of strings words.
 * A string is consistent if all characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 */
public class CountTheNumberOfConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (char c : allowed.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        int ans = 0;
        for (String word : words) {
            int curMask = 0;
            for (char c : word.toCharArray()) {
                curMask |= 1 << (c - 'a');
            }
            if ((curMask & mask) == curMask) {
                ans++;
            }
        }
        return ans;
    }

}
