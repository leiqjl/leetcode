package com.leiqjl;

import java.util.Arrays;

/**
 * 135. Candy - Hard
 * <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * - Each child must have at least one candy.
 * - Children with a higher rating get more candies than their neighbors.
 * <p>
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */
public class Candy {

    // time O(n) space O(1)
    public int candy(int[] ratings) {
        int sum = 1;
        int up = 1, down = 1, peek = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                up++;
                down = 1;
                peek = up;
                sum += up;
            } else if (ratings[i - 1] > ratings[i]) {
                down++;
                up = 1;
                sum += down + (peek >= down ? -1 : 0);
            } else {
                up = down = peek = 1;
                sum += 1;
            }
        }
        return sum;
    }

    // time O(n) space O(n)
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        int sum = candies[0];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = Math.max(candies[i - 1] + 1, candies[i]);
            }
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        //Input: ratings = [1,0,2]
        //Output: 5
        //Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
        int[] rating = {1, 0, 2};
        assert c.candy(rating) == 5;
        //Input: ratings = [1,2,2]
        //Output: 4
        //Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
        //The third child gets 1 candy because it satisfies the above two conditions.
        int[] rating1 = {1, 2, 2};
        assert c.candy(rating1) == 4;

        int[] rating2 = {0, 1, 20, 9, 8, 7};
        assert c.candy(rating2) == 13;
    }
}
