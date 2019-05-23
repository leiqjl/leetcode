package com.leiqjl;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, result, 0, new StringBuilder());
        return result;
    }

    private void backtrack(String digits, List<String> list, int offset, StringBuilder sb){
        if(offset == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = KEYS[digits.charAt(offset) - '0'];
        for(int i = 0;i< str.length();i++){
            sb.append(str.charAt(i));
            backtrack(digits,list,offset+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();
        String digits = "23";
        System.out.println(solution.letterCombinations(digits));
    }
}
