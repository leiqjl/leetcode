package com.leiqjl;

import java.util.Arrays;

/**
 * 881. Boats to Save People - Medium
 * <p>
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
 * <p>
 * Return the minimum number of boats to carry every given person.
 */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int i = 0, j = people.length - 1;
        Arrays.sort(people);
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }

        return people.length - 1 - j;
    }

}
