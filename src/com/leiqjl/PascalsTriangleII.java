package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II - Easy
 */
public class PascalsTriangleII {
    //0 <= rowIndex <= 33
    public List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        dp[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                dp[j] += dp[j - 1];
            }
        }
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int num : dp) {
            result.add(num);
        }
        return result;
    }
}
