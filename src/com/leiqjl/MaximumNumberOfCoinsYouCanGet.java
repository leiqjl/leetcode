package com.leiqjl;

import java.util.Arrays;

/**
 * 1561. Maximum Number of Coins You Can Get - Medium
 * There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:
 * <p>
 * ·In each step, you will choose any 3 piles of coins (not necessarily consecutive).
 * ·Of your choice, Alice will pick the pile with the maximum number of coins.
 * ·You will pick the next pile with the maximum number of coins.
 * ·Your friend Bob will pick the last pile.
 * ·Repeat until there are no more piles of coins.
 * Given an array of integers piles where piles[i] is the number of coins in the ith pile.
 * <p>
 * Return the maximum number of coins that you can have.
 */
public class MaximumNumberOfCoinsYouCanGet {
    //piles.length = 3n
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberOfCoinsYouCanGet m = new MaximumNumberOfCoinsYouCanGet();

        assert m.maxCoins(new int[]{2, 4, 1, 2, 7, 8}) == 9;

        assert m.maxCoins(new int[]{2, 4, 5}) == 4;

        assert m.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}) == 18;
    }
}
