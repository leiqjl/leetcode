package com.leiqjl;

/**
 * 926. Flip String to Monotone Increasing - Medium
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
 * <p>
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 * <p>
 * Return the minimum number of flips to make s monotone increasing.
 */
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int ones = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                res = Math.min(ones, res + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing f = new FlipStringToMonotoneIncreasing();
        //Input: s = "00110"
        //Output: 1
        //Explanation: We flip the last digit to get 00111.
        assert f.minFlipsMonoIncr("00110") == 1;
        //Input: s = "010110"
        //Output: 2
        //Explanation: We flip to get 011111, or alternatively 000111.
        assert f.minFlipsMonoIncr("010110") == 2;
        //Input: s = "00011000"
        //Output: 2
        //Explanation: We flip to get 00000000.
        assert f.minFlipsMonoIncr("00011000") == 2;
    }
}
