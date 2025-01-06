package com.leiqjl;

import java.util.Objects;

/**
 * 2381. Shifting Letters II - Medium
 */
public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diffArr = new int[s.length()];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 0 ? -1 : 1;
            diffArr[start] += direction;
            if (end + 1 < diffArr.length) {
                diffArr[end + 1] -= direction;
            }
        }
        char[] charArray = s.toCharArray();
        int diff = 0;
        for (int i = 0; i < diffArr.length; i++) {
            diff += diffArr[i];
            charArray[i] = (char) (((charArray[i] - 'a' + diff) % 26 + 26) % 26 + 'a');
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        ShiftingLettersII s = new ShiftingLettersII();
        assert Objects.equals(s.shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}), "ace");
        assert Objects.equals(s.shiftingLetters("dztz", new int[][]{{0, 0, 0}, {1, 1, 1}}), "catz");
    }
}
