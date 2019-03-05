package com.leiqjl;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Input:"PAYPALISHIRING", numRows = 3
 * Output:"PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows < 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        int len = numRows * 2 - 2;
        for (int i = 0; i <= numRows; i++) {
            for (int j = 0; j + i < n; j += len) {
                builder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + len - i < n)
                    builder.append(s.charAt(j + len - i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigZagConversion test = new ZigZagConversion();
        String result = test.convert(s, 3);
        System.out.println(result);
    }
}
