package com.leiqjl;

/**
 * 2278. Percentage of Letter in String - Easy
 * <p>
 * Given a string s and a character letter, return the percentage of characters in s that equal letter rounded down to the nearest whole percent.
 */
public class PercentageOfLetterInString {
    //1 <= s.length <= 100
    //s consists of lowercase English letters.
    //letter is a lowercase English letter.
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }
}
