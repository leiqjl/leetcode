package com.leiqjl;

/**
 * 1700. Number of Students Unable to Eat Lunch - Easy
 */
public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroCount = 0, oneCount = 0;
        for (int student : students) {
            if (student == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        for (int s : sandwiches) {
            if (s == 1 && oneCount == 0) {
                return zeroCount;
            }
            if (s == 0 && zeroCount == 0) {
                return oneCount;
            }
            if (s == 1) {
                oneCount--;
            } else {
                zeroCount--;
            }
        }
        return 0;
    }
}
