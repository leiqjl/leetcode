package com.leiqjl;

/**
 * 1232. Check If It Is a Straight Line - Easy
 */
public class CheckIfItIsAStraightLine {
    //Constraints:
    //
    //2 <= coordinates.length <= 1000
    //coordinates[i].length == 2
    //-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    //coordinates contains no duplicate point.
    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            if (dx * (coordinates[i][1] - coordinates[0][1]) != dy * (coordinates[i][0] - coordinates[0][0])) {
                return false;
            }
        }
        return true;
    }
}
