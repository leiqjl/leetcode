package com.leiqjl;

import java.util.Arrays;

/**
 * 2551. Put Marbles in Bags - Hard
 * You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.
 * <p>
 * Divide the marbles into the k bags according to the following rules:
 * <p>
 * ·No bag is empty.
 * ·If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
 * ·If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
 * The score after distributing the marbles is the sum of the costs of all the k bags.
 * <p>
 * Return the difference between the maximum and minimum scores among marble distributions.
 */
public class PutMarblesInBags {
    //Constraints:
    //
    //1 <= k <= weights.length <= 10^5
    //1 <= weights[i] <= 10^9

    //greedy
    public long putMarbles(int[] weights, int k) {
        if (k == 1 || k == weights.length) {
            return 0;
        }
        //weights[0] + weights[n-1]
        //[0, i] [i+1, n-1] weights[0]+weights[i] + weights[i+1]+ weights[n-1]
        int[] arr = new int[weights.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += (arr[arr.length - 1 - i] - arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        PutMarblesInBags p = new PutMarblesInBags();
        //Input: weights = [1,3,5,1], k = 2
        //Output: 4
        //Explanation:
        //The distribution [1],[3,5,1] results in the minimal score of (1+1) + (3+1) = 6.
        //The distribution [1,3],[5,1], results in the maximal score of (1+3) + (5+1) = 10.
        //Thus, we return their difference 10 - 6 = 4.
        assert p.putMarbles(new int[]{1, 3, 5, 1}, 2) == 4;
        assert p.putMarbles(new int[]{1, 3}, 2) == 0;
        assert p.putMarbles(new int[]{2, 4, 6}, 2) == 4;
    }
}
