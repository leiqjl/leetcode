package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2438. Range Product Queries of Powers - Medium
 */
public class RangeProductQueriesOfPowers {
    //29   0+1+2+...+28
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        List<Integer> list = new ArrayList<>();
        int base = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                list.add(base);
            }
            n >>>= 1;
            base <<= 1;
        }
        int m = list.size();
        int[][] prefix = new int[m][m];
        for (int i = 0; i < m; i++) {
            long temp = 1;
            for (int j = i; j < m; j++) {
                temp = (temp * list.get(j)) % mod;
                prefix[i][j] = (int) temp;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefix[queries[i][0]][queries[i][1]];
        }
        return ans;
    }

    public static void main(String[] args) {
        RangeProductQueriesOfPowers r = new RangeProductQueriesOfPowers();
        assert Arrays.equals(r.productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}}), new int[]{2, 4, 64});
        assert Arrays.equals(r.productQueries(2, new int[][]{{0, 0}}), new int[]{2});
    }
}
