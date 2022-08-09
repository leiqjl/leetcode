package com.leiqjl;

/**
 * 458. Poor Pigs - Hard
 */
public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int perPig = minutesToTest / minutesToDie + 1;
        int count = 0;
        while (Math.pow(perPig, count) < buckets) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        PoorPigs p = new PoorPigs();
        //Input: buckets = 1000, minutesToDie = 15, minutesToTest = 60
        //Output: 5
        assert p.poorPigs(1000, 15, 60) == 5;
        //Input: buckets = 4, minutesToDie = 15, minutesToTest = 15
        //Output: 2
        assert p.poorPigs(4, 15, 15) == 2;
        //Input: buckets = 4, minutesToDie = 15, minutesToTest = 30
        //Output: 2
        assert p.poorPigs(4, 15, 30) == 2;
    }
}
