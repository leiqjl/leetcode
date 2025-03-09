package com.leiqjl;

/**
 * 3208. Alternating Groups II - Medium
 */
public class AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int last = colors[0], count = 1;
        for (int i = 1; i < colors.length + k - 1; i++) {
            int idx = i % colors.length;
            if (colors[idx] == last) {
                count = 1;
                continue;
            }
            count++;
            last = colors[idx];
            if (count >= k) {
                res++;
            }
        }
        return res;
    }
}
