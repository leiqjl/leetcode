package com.leiqjl;

import java.util.Arrays;

/**
 * 2433. Find The Original Array of Prefix Xor - Medium
 * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 * <p>
 * - pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * Note that ^ denotes the bitwise-xor operation.
 * <p>
 * It can be proven that the answer is unique.
 */
public class FindTheOriginalArrayOfPrefixXor {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] res = new int[n];
        res[0] = pref[0];
        for (int i = 1; i < n; i++) {
            res[i] = pref[i] ^ pref[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        FindTheOriginalArrayOfPrefixXor f = new FindTheOriginalArrayOfPrefixXor();
        //Input: pref = [5,2,0,3,1]
        //Output: [5,7,2,3,2]
        //- pref[0] = 5.
        //- pref[1] = 5 ^ 7 = 2.
        //- pref[2] = 5 ^ 7 ^ 2 = 0.
        //- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
        //- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
        int[] pref = {5, 2, 0, 3, 1};
        assert Arrays.toString(f.findArray(pref)).equals("[5, 7, 2, 3, 2]");
        //Input: pref = [13]
        //Output: [13]
        //Explanation: We have pref[0] = arr[0] = 13.
        assert Arrays.toString(f.findArray(new int[]{13})).equals("[13]");
    }
}
