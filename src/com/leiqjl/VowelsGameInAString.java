package com.leiqjl;

/**
 * 3227. Vowels Game in a String - Medium
 */
public class VowelsGameInAString {
    // n = 0  alice lose
    // n = odd alice win take all
    // n = even alice win take n-1
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }
}
