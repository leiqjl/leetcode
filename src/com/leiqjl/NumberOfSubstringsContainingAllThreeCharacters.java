package com.leiqjl;

/**
 * 1358. Number of Substrings Containing All Three Characters - Medium
 * Given a string s consisting only of characters a, b and c.
 * <p>
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 */
public class NumberOfSubstringsContainingAllThreeCharacters {
    //sliding window
    public int numberOfSubstrings1(String s) {
        int n = s.length();
        int[] arr = new int[3];
        int res = 0;
        int l = 0, r = 0;
        while (r < n) {
            int idx = s.charAt(r) - 'a';
            arr[idx]++;
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                res += n - r;
                idx = s.charAt(l) - 'a';
                arr[idx]--;
                l++;
            }
            r++;
        }
        return res;
    }

    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] lastPos = {-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
            res += Math.min(Math.min(lastPos[0], lastPos[1]), lastPos[2]) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubstringsContainingAllThreeCharacters m = new NumberOfSubstringsContainingAllThreeCharacters();
        assert m.numberOfSubstrings("abcabc") == 10;
        assert m.numberOfSubstrings("aaacb") == 3;
    }
}
