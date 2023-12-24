package com.leiqjl;

/**
 * 1903. Largest Odd Number in String - Easy
 */
public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) & 1) == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LargestOddNumberInString l = new LargestOddNumberInString();
        assert l.largestOddNumber("52").equals("5");
        assert l.largestOddNumber("4206").equals("");
        assert l.largestOddNumber("35427").equals("35427");
    }
}
