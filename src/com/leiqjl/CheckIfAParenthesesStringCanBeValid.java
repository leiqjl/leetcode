package com.leiqjl;

/**
 * 2116. Check if a Parentheses String Can Be Valid - Medium
 */
public class CheckIfAParenthesesStringCanBeValid {

    //n == s.length == locked.length
    //1 <= n <= 105
    //s[i] is either '(' or ')'.
    //locked[i] is either '0' or '1'.
    public boolean canBeValid(String s, String locked) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        int unlocked = 0, open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }
            if (unlocked + open - close < 0) {
                return false;
            }
        }
        unlocked = open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }
            if((unlocked + close - open) < 0) {
                return false;
            }
        }
        return true;
    }
    //Input: s = "))()))", locked = "010100"
    //Output: true
    //Input: s = "()()", locked = "0000"
    //Output: true
    //Input: s = ")", locked = "0"
    //Output: false
}
