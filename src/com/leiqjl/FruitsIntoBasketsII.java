package com.leiqjl;

/**
 * 3477. Fruits Into Baskets II - Easy
 */
public class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        for (int fruit : fruits) {
            for (int i = 0; i < n; i++) {
                if (baskets[i] >= fruit) {
                    baskets[i] = 0;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}
