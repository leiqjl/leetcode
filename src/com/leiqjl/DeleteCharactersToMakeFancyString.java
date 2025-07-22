package com.leiqjl;

/**
 * 1957. Delete Characters to Make Fancy String - Easy
 */
public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char last = sb.charAt(0);
        sb.append(last);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                count++;
            } else {
                last = s.charAt(i);
                count = 1;
            }
            if (count < 3) {
                sb.append(last);
            }
        }
        return sb.toString();
    }
}
