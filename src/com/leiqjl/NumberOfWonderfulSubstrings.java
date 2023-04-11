package com.leiqjl;

/**
 * 1915. Number of Wonderful Substrings - Medium
 */
public class NumberOfWonderfulSubstrings {
    //Constraints:
    //
    //1 <= word.length <= 10^5
    //word consists of lowercase English letters from 'a' to 'j'.
    public long wonderfulSubstrings(String word) {
        long result = 0;
        int n = word.length();
        int[] count = new int[1024];
        count[0] = 1;
        int mask = 0;
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            mask ^= (1 << idx);
            result += count[mask];
            for (int j = 0; j < 10; j++) {
                result += count[mask ^ (1 << j)];
            }
            count[mask]++;
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfWonderfulSubstrings n = new NumberOfWonderfulSubstrings();
        assert n.wonderfulSubstrings("aba") == 4;
        assert n.wonderfulSubstrings("aabb") == 9;
    }
}
