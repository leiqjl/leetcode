package com.leiqjl;

/**
 * 1844. Replace All Digits with Characters - Easy
 */
public class ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) (chars[i - 1] + chars[i] - '0');
        }
        return new String(chars);
    }
}
