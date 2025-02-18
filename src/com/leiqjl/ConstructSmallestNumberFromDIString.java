package com.leiqjl;

/**
 * 2375. Construct Smallest Number From DI String - Medium
 * You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.
 * <p>
 * A 0-indexed string num of length n + 1 is created using the following conditions:
 * <p>
 * · num consists of the digits '1' to '9', where each digit is used at most once.
 * · If pattern[i] == 'I', then num[i] < num[i + 1].
 * · If pattern[i] == 'D', then num[i] > num[i + 1].
 * Return the lexicographically smallest possible string num that meets the conditions.
 */
public class ConstructSmallestNumberFromDIString {
    //Constraints:
    //
    //1 <= pattern.length <= 8
    //pattern consists of only the letters 'I' and 'D'.
    public String smallestNumber(String pattern) {
        StringBuilder stringBuilder = new StringBuilder(pattern.length() + 1);
        int index = 1, DCount = 0;
        for (int i = 0; i <= pattern.length(); i++) {
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                if (DCount > 0) {
                    int start = index + DCount;
                    for (int j = start; j >= index; j--) {
                        stringBuilder.append(j);
                    }
                    index = start + 1;
                    DCount = 0;
                } else {
                    stringBuilder.append(index++);
                }
            } else {
                DCount++;
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        ConstructSmallestNumberFromDIString c = new ConstructSmallestNumberFromDIString();
        assert c.smallestNumber("IIIDIDDD").equals("123549876");
        assert c.smallestNumber("DDD").equals("4321");
    }
}
