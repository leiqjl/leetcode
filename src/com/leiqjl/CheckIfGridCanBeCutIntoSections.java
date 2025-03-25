package com.leiqjl;

import java.util.Arrays;

/**
 * 3394. Check if Grid can be Cut into Sections - Medium
 */
public class CheckIfGridCanBeCutIntoSections {
    //Constraints:
    //
    //3 <= n <= 10^9
    //3 <= rectangles.length <= 105
    //0 <= rectangles[i][0] < rectangles[i][2] <= n
    //0 <= rectangles[i][1] < rectangles[i][3] <= n
    //No two rectangles overlap.
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);
        int count = 0, lastEnd = 0;
        for (int[] r : rectangles) {
            if (r[0] >= lastEnd) {
                count++;
                lastEnd = r[2];
            } else if (r[2] > lastEnd) {
                lastEnd = r[2];
            }
            if (count == 3) {
                return true;
            }
        }
        Arrays.sort(rectangles, (a, b) -> a[1] - b[1]);
        count = 0;
        lastEnd = 0;
        for (int[] r : rectangles) {
            if (r[1] >= lastEnd) {
                count++;
                lastEnd = r[3];
            } else if (r[3] > lastEnd) {
                lastEnd = r[3];
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfGridCanBeCutIntoSections c = new CheckIfGridCanBeCutIntoSections();
        //Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
        //Output: true
        assert c.checkValidCuts(5, new int[][]{{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}});
        //Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
        //Output: true
        assert c.checkValidCuts(4, new int[][]{{0, 0, 1, 1}, {2, 0, 3, 4}, {0, 2, 2, 3}, {3, 0, 4, 3}});
    }
}
