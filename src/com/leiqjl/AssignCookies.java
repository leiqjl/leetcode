package com.leiqjl;

import java.util.Arrays;

/**
 * 455. Assign Cookies - Easy
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }
}
