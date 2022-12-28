package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 1962. Remove Stones to Minimize the Total - Medium
 */
public class RemoveStonesToMinimizeTheTotal {

    public int minStoneSum1(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(piles.length, (a, b) -> Integer.compare(b, a));
        for (int pile : piles) {
            maxHeap.add(pile);
            sum += pile;
        }
        while (k > 0) {
            int max = maxHeap.remove();
            sum -= max / 2;
            maxHeap.add(max - max / 2);
            k--;
        }
        return sum;
    }

    //1 <= piles.length <= 10^5
    //1 <= piles[i] <= 10^4
    //1 <= k <= 10^5
    public int minStoneSum(int[] piles, int k) {
        int[] arr = new int[10001];
        for (int pile : piles) {
            arr[pile]++;
        }
        for (int i = 10000; i > 0 && k > 0; i--) {
            if (arr[i] == 0) {
                continue;
            }
            int temp = Math.min(arr[i], k);
            arr[i] -= temp;
            arr[i - i / 2] += temp;
            k -= temp;
        }
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i * arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal r = new RemoveStonesToMinimizeTheTotal();
        assert r.minStoneSum(new int[]{5, 4, 9}, 2) == 12;
        assert r.minStoneSum(new int[]{4, 3, 6, 7}, 3) == 12;
        assert r.minStoneSum(new int[]{10000}, 10000) == 1;
    }
}
