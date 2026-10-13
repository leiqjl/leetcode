package com.leiqjl;

/**
 * 1541. Minimum Insertions to Balance a Parentheses String - Medium
 */
public class MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {
        int needCount = 0, leftCount = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                leftCount++;
                index++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    needCount++;
                }
                if (index < s.length() - 1 && s.charAt(index + 1) == ')') {
                    index += 2;
                } else {
                    needCount++;
                    index++;
                }
            }
        }
        return needCount + leftCount * 2;
    }

    public static void main(String[] args) {
        MinimumInsertionsToBalanceAParenthesesString m = new MinimumInsertionsToBalanceAParenthesesString();
        assert m.minInsertions("(()))") == 1;
        assert m.minInsertions("())") == 0;
        assert m.minInsertions("))())(") == 3;
    }
}
