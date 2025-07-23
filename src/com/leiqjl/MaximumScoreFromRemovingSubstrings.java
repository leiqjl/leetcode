package com.leiqjl;

/**
 * 1717. Maximum Score From Removing Substrings - Medium
 */
public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        char a = 'a', b = 'b';
        if (y > x) {
            a = 'b';
            b = 'a';
            int temp = x;
            x = y;
            y = temp;
        }
        int ans = 0;
        int aCount = 0, bCount = 0;
        for (char c : s.toCharArray()) {
            if (c == a) {
                aCount++;
            } else if (c == b) {
                if (aCount > 0) {
                    ans += x;
                    aCount--;
                } else {
                    bCount++;
                }
            } else {
                ans += (y * Math.min(aCount, bCount));
                aCount = 0;
                bCount = 0;
            }
        }
        ans += (y * Math.min(aCount, bCount));
        return ans;
    }

    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings m = new MaximumScoreFromRemovingSubstrings();
        assert m.maximumGain("cdbcbbaaabab", 4, 5) == 19;
        assert m.maximumGain("aabbaaxybbaabb", 5, 4) == 20;
    }
}
