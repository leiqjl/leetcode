package com.leiqjl;

import java.util.Arrays;

/**
 * 2037. Minimum Number of Moves to Seat Everyone - Easy
 */
public class MinimumNumberOfMovesToSeatEveryone {
    //Constraints:
    //
    //n == seats.length == students.length
    //1 <= n <= 100
    //1 <= seats[i], students[j] <= 100
    public int minMovesToSeat(int[] seats, int[] students) {

        int[] counts = new int[101];
        for (int i = 0; i < seats.length; i++) {
            counts[seats[i]]++;
            counts[students[i]]--;
        }
        int moves = 0, unfilled = 0;
        for (int count : counts) {
            moves += Math.abs(unfilled);
            unfilled += count;
        }
        return moves;
    }

    public int minMovesToSeat1(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

    public static void main(String[] args) {
        MinimumNumberOfMovesToSeatEveryone m = new MinimumNumberOfMovesToSeatEveryone();
        //Input: seats = [3,1,5], students = [2,7,4]
        //Output: 4
        assert m.minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}) == 4;
        //Input: seats = [4,1,5,9], students = [1,3,2,6]
        //Output: 7
        assert m.minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}) == 7;
    }
}
