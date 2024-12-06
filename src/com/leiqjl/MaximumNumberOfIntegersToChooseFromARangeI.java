package com.leiqjl;

/**
 * 2554. Maximum Number of Integers to Choose From a Range I - Medium
 * <p>
 * You are given an integer array banned and two integers n and maxSum. You are choosing some number of integers following the below rules:
 * <p>
 * ·The chosen integers have to be in the range [1, n].
 * ·Each integer can be chosen at most once.
 * ·The chosen integers should not be in the array banned.
 * ·The sum of the chosen integers should not exceed maxSum.
 * <p>
 * Return the maximum number of integers you can choose following the mentioned rules.
 */
public class MaximumNumberOfIntegersToChooseFromARangeI {
    //Constraints:
    //1 <= banned.length <= 10^4
    //1 <= banned[i], n <= 10^4
    //1 <= maxSum <= 10^9
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] bannedSet = new int[10001];
        for (int b : banned) {
            bannedSet[b] = 1;
        }
        int count = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet[i] == 1) {
                continue;
            }
            sum += i;
            if (sum > maxSum) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        MaximumNumberOfIntegersToChooseFromARangeI m = new MaximumNumberOfIntegersToChooseFromARangeI();
        assert m.maxCount(new int[]{1, 6, 5}, 5, 6) == 2;
        assert m.maxCount(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, 1) == 0;
        assert m.maxCount(new int[]{11}, 7, 50) == 7;
    }
}
