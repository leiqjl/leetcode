package com.leiqjl;

/**
 * 3100. Water Bottles II - Medium
 */
public class WaterBottlesII {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            res++;
            numBottles = numBottles - numExchange + 1;
            numExchange++;
        }
        return res;
    }

    public static void main(String[] args) {
        WaterBottlesII w = new WaterBottlesII();
        assert w.maxBottlesDrunk(13, 6) == 15;
        assert w.maxBottlesDrunk(10, 3) == 13;
    }
}
