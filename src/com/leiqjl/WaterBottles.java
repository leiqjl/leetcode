package com.leiqjl;

/**
 * 1518. Water Bottles - Easy
 * There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.
 * <p>
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * <p>
 * Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
 */
public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            int exchanged = numBottles / numExchange;
            res += exchanged;
            numBottles = exchanged + numBottles % numExchange;
        }
        return res;
    }
}
