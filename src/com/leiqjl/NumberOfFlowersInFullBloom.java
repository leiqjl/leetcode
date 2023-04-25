package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2251. Number of Flowers in Full Bloom - Hard
 */
public class NumberOfFlowersInFullBloom {
    //Constraints:
    //
    //1 <= flowers.length <= 5 * 10^4
    //flowers[i].length == 2
    //1 <= starti <= endi <= 10^9
    //1 <= people.length <= 5 * 10^4
    //1 <= people[i] <= 10^9
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<int[]> list = new ArrayList<>(flowers.length * 2 + people.length);
        for (int[] flower : flowers) {
            list.add(new int[]{flower[0], 0});
            list.add(new int[]{flower[1], 2});
        }
        for (int i = 0; i < people.length; i++) {
            list.add(new int[]{people[i], 1, i});
        }
        list.sort((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int bloomCount = 0;
        int[] result = new int[people.length];
        for (int[] pair : list) {
            if (pair[1] == 0) {
                bloomCount++;
            } else if (pair[1] == 2) {
                bloomCount--;
            } else {
                result[pair[2]] = bloomCount;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfFlowersInFullBloom n = new NumberOfFlowersInFullBloom();
        //Input: flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
        //Output: [1,2,2,2]
        assert "[1, 2, 2, 2]".equals(Arrays.toString(n.fullBloomFlowers(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11})));
        //Input: flowers = [[1,10],[3,3]], people = [3,3,2]
        //Output: [2,2,1]
        assert "[2, 2, 1]".equals(Arrays.toString(n.fullBloomFlowers(new int[][]{{1, 10}, {3, 3}}, new int[]{3, 3, 2})));
    }
}
