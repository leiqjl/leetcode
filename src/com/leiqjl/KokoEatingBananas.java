package com.leiqjl;

/**
 * 875. Koko Eating Bananas - Medium
 * <p>
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBananas {
    //1 <= piles.length <= 10^4
    //piles.length <= h <= 10^9
    //1 <= piles[i] <= 10^9
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int temp = 0;
            for (int pile : piles) {
                temp = temp + (pile + mid - 1) / mid;
            }
            if (temp > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas k = new KokoEatingBananas();
        assert k.minEatingSpeed(new int[]{3, 6, 7, 11}, 8) == 4;
        assert k.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5) == 30;
        assert k.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6) == 23;
    }
}
