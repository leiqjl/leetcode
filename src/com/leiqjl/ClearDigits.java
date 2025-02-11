package com.leiqjl;

/**
 * 3174. Clear Digits - Easy
 * You are given a string s.
 * <p>
 * Your task is to remove all digits by doing this operation repeatedly:
 * <p>
 * ·Delete the first digit and the closest non-digit character to its left.
 * Return the resulting string after removing all digits.
 */
public class ClearDigits {
    //Constraints:
    //
    //1 <= s.length <= 100
    //s consists only of lowercase English letters and digits.
    //The input is generated such that it is possible to delete all digits.
    public String clearDigits(String s) {
        char[] charArray = s.toCharArray();
        int idx = 0;
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                idx--;
            } else {
                charArray[idx++] = c;
            }
        }
        return new String(charArray, 0, idx);
    }

    public static void main(String[] args) {
        ClearDigits c = new ClearDigits();
        assert c.clearDigits("abc").equals("abc");
        assert c.clearDigits("cb34").equals("");
    }
}
