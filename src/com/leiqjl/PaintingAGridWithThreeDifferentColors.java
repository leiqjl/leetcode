package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1931. Painting a Grid With Three Different Colors - Hard
 * You are given two integers m and n. Consider an m x n grid where each cell is initially white. You can paint each cell red, green, or blue. All cells must be painted.
 * <p>
 * Return the number of ways to color the grid with no two adjacent cells having the same color. Since the answer can be very large, return it modulo 10^9 + 7.
 */
public class PaintingAGridWithThreeDifferentColors {
    //Constraints:
    //
    //1 <= m <= 5
    //1 <= n <= 1000
    public int colorTheGrid(int m, int n) {
        int mod = 1000000007;
        int max = 1;
        for (int i = 0; i < m; i++) {
            max *= 3;
        }
        Map<Integer, List<Integer>> maskMap = new HashMap<>();
        for (int mask = 0; mask < max; mask++) {
            List<Integer> colors = new ArrayList<>();
            int temp = mask;
            for (int i = 0; i < m; i++) {
                colors.add(temp % 3);
                temp /= 3;
            }
            boolean flag = true;
            for (int i = 1; i < m; i++) {
                if (colors.get(i).equals(colors.get(i - 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                maskMap.put(mask, colors);
            }
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int m1 : maskMap.keySet()) {
            for (int m2 : maskMap.keySet()) {
                boolean flag = true;
                for (int i = 0; i < m; i++) {
                    if (maskMap.get(m1).get(i).equals(maskMap.get(m2).get(i))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    adj.computeIfAbsent(m1, mask -> new ArrayList<>()).add(m2);
                }
            }
        }
        Map<Integer, Integer> dp = new HashMap<>();
        for (int mask : maskMap.keySet()) {
            dp.put(mask, 1);
        }
        for (int col = 1; col < n; col++) {
            Map<Integer, Integer> tempArr = new HashMap<>();
            for (int m1 : maskMap.keySet()) {
                for (int m2 : adj.getOrDefault(m1, new ArrayList<>())) {
                    tempArr.put(m1, (tempArr.getOrDefault(m1, 0) + dp.getOrDefault(m2, 0)) & mod);
                }
            }
            dp = tempArr;
        }
        int res = 0;
        for (int num : dp.values()) {
            res = (res + num) % mod;
        }
        return res;
    }
}
