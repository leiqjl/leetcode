package com.leiqjl;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number - Medium
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        recursive(digits, result, 0, new StringBuilder());
        return result;
    }

    private void recursive(String digits, List<String> list, int offset, StringBuilder sb) {
        if (offset == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            recursive(digits, list, offset + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
