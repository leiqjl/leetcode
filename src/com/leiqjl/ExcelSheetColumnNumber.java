package com.leiqjl;

/**
 * 171. Excel Sheet Column Number - Easy
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}
