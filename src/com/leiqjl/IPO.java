package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 502. IPO - Hard
 */
public class IPO {
    //Constraints:
    //
    //1 <= k <= 10^5
    //0 <= w <= 10^9
    //n == profits.length
    //n == capital.length
    //1 <= n <= 10^5
    //0 <= profits[i] <= 10^4
    //0 <= capital[i] <= 10^9
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] cpPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            cpPairs[i][0] = capital[i];
            cpPairs[i][1] = profits[i];
        }
        Arrays.sort(cpPairs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int idx = 0;
        while (k > 0) {
            while (idx <n && cpPairs[idx][0] <= w) {
                priorityQueue.offer(cpPairs[idx++]);
            }
            if (priorityQueue.isEmpty()) {
                break;
            }
            w += priorityQueue.poll()[1];
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        IPO i = new IPO();
        //Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
        //Output: 4
        assert i.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}) == 4;
        //Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
        //Output: 6
        assert i.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}) == 6;
    }
}
