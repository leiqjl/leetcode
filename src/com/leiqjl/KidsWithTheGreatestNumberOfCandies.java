package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies - Easy
 */
public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candie : candies) {
            max = Math.max(max, candie);
        }
        max -= extraCandies;
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candie : candies) {
            result.add(candie >= max);
        }
        return result;
    }
}
