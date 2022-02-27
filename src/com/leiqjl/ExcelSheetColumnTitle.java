package com.leiqjl;

/**
 * 168. Excel Sheet Column Title - Easy
 * <p>
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) return "";
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) ('A' + (columnNumber % 26)));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

}
