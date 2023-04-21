package com.leiqjl;

import java.util.Arrays;

/**
 * 879. Profitable Schemes - Hard
 */
public class ProfitableSchemes {
    //Constraints:
    //
    //1 <= n <= 100
    //0 <= minProfit <= 100
    //1 <= group.length <= 100
    //1 <= group[i] <= 100
    //profit.length == group.length
    //0 <= profit[i] <= 100
    int mod = 1000000007;
    int[][][] mem = new int[101][101][101];

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        return profitableSchemesHelper(0, 0, 0, n, minProfit, group, profit);
    }

    private int profitableSchemesHelper(int curIdx, int curProfit, int num, int n, int minProfit, int[] group, int[] profit) {
        if (curIdx == group.length) {
            return curProfit >= minProfit ? 1 : 0;
        }
        if (mem[curIdx][num][curProfit] != -1) {
            return mem[curIdx][num][curProfit];
        }
        int result = profitableSchemesHelper(curIdx + 1, curProfit, num, n, minProfit, group, profit);
        if (num + group[curIdx] <= n) {
            result += profitableSchemesHelper(curIdx + 1, Math.min(minProfit, curProfit + profit[curIdx]), num + group[curIdx], n, minProfit, group, profit);
        }
        mem[curIdx][num][curProfit] = result % mod;
        return mem[curIdx][num][curProfit];
    }

    public static void main(String[] args) {
        ProfitableSchemes p = new ProfitableSchemes();
        assert p.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}) == 2;
        assert p.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}) == 7;
    }
}
