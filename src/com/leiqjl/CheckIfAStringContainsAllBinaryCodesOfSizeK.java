package com.leiqjl;

import java.util.HashSet;

/**
 * 1461. Check If a String Contains All Binary Codes of Size K - Medium
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    //1 <= s.length <= 5 * 10^5
    //s[i] is either '0' or '1'.
    //1 <= k <= 20
    public boolean hasAllCodes1(String s, int k) {
        int count = 1 << k;
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String str = s.substring(i, i + k);
            if (!hashSet.contains(str)) {
                hashSet.add(str);
                count--;
                if (count == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasAllCodes(String s, int k) {
        int count = 1 << k;
        boolean[] mark = new boolean[count];
        int mask = count - 1;
        int bit = 0;
        for (int i = 0; i < s.length(); i++) {
            bit = ((bit << 1) & mask) | (s.charAt(i) - '0');
            if (i < k - 1) {
                continue;
            }
            if (mark[bit]) {
                continue;
            }
            mark[bit] = true;
            count--;
            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfAStringContainsAllBinaryCodesOfSizeK c = new CheckIfAStringContainsAllBinaryCodesOfSizeK();
        //Input: s = "00110110", k = 2
        //Output: true
        //Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
        String s = "00110110";
        System.out.println(c.hasAllCodes(s, 2));
        //Input: s = "0110", k = 1
        //Output: true
        //Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
        String s1 = "0110";
        System.out.println(c.hasAllCodes(s1, 1));
        //Input: s = "0110", k = 2
        //Output: false
        //Explanation: The binary code "00" is of length 2 and does not exist in the array.
        String s2 = "0110";
        System.out.println(c.hasAllCodes(s2, 2));
        //"00110"
        //2
        String s3 = "00110";
        System.out.println(c.hasAllCodes(s3, 2));
    }
}
