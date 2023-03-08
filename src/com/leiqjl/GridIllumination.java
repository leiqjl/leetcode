package com.leiqjl;

import java.util.*;

/**
 * 1001. Grid Illumination - Hard
 */
public class GridIllumination {
    //Constraints:
    //
    //1 <= n <= 10^9
    //0 <= lamps.length <= 20000
    //0 <= queries.length <= 20000
    //lamps[i].length == 2
    //0 <= rowi, coli < n
    //queries[j].length == 2
    //0 <= rowj, colj < n

//    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
//        int[] flagCol = new int[n];
//        int[] flagRow = new int[n];
//        int[] flag45 = new int[n * 2];
//        int[] flag135 = new int[n * 2];
//        boolean[][] grids = new boolean[n][n];
//        for (int[] lamp : lamps) {
//            int row = lamp[0];
//            int col = lamp[1];
//            if (grids[row][col]) {
//                continue;
//            }
//            grids[row][col] = true;
//            flagRow[row] += 1;
//            flagCol[col] += 1;
//            flag45[col + row] += 1;
//            flag135[col - row + n - 1] += 1;
//        }
//        int[] result = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int row = queries[i][0];
//            int col = queries[i][1];
//            if (!grids[row][col] && flagRow[row] == 0 && flagCol[col] == 0 && flag45[col + row] == 0 && flag135[col - row + n - 1] == 0) {
//                result[i] = 0;
//                continue;
//            }
//            for (int j = Math.max(0, row - 1); j <= Math.min(row + 1, n - 1); j++) {
//                for (int k = Math.max(0, col - 1); k <= Math.min(col + 1, n - 1); k++) {
//                    if (grids[j][k]) {
//                        grids[j][k] = false;
//                        flagRow[j] -= 1;
//                        flagCol[k] -= 1;
//                        flag45[k + j] -= 1;
//                        flag135[k - j + n - 1] -= 1;
//                    }
//                }
//            }
//            result[i] = 1;
//        }
//        return result;
//    }


    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> flagRow = new HashMap<>();
        Map<Integer, Integer> flagCol = new HashMap<>();
        Map<Integer, Integer> flag45 = new HashMap<>();
        Map<Integer, Integer> flag135 = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] lamp : lamps) {
            int row = lamp[0];
            int col = lamp[1];
            Set<Integer> set = map.computeIfAbsent(row, a -> new HashSet<>());
            if (set.contains(col)) {
                continue;
            }
            set.add(col);
            flagRow.put(row, flagRow.getOrDefault(row, 0) + 1);
            flagCol.put(col, flagCol.getOrDefault(col, 0) + 1);
            flag45.put(col + row, flag45.getOrDefault(col + row, 0) + 1);
            flag135.put(col - row + n - 1, flag135.getOrDefault(col - row + n - 1, 0) + 1);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0];
            int col = queries[i][1];
            if (flagRow.getOrDefault(row, 0) == 0
                    && flagCol.getOrDefault(col, 0) == 0
                    && flag45.getOrDefault(col + row, 0) == 0
                    && flag135.getOrDefault(col - row + n - 1, 0) == 0) {
                result[i] = 0;
                continue;
            }
            result[i] = 1;
            for (int j = Math.max(0, row - 1); j <= Math.min(row + 1, n - 1); j++) {
                for (int k = Math.max(0, col - 1); k <= Math.min(col + 1, n - 1); k++) {
                    Set<Integer> set = map.computeIfAbsent(j, a -> new HashSet<>());
                    if (set.contains(k)) {
                        set.remove(k);
                        flagRow.put(j, flagRow.get(j) - 1);
                        flagCol.put(k, flagCol.get(k) - 1);
                        flag45.put(k + j, flag45.get(k + j) - 1);
                        flag135.put(k - j + n - 1, flag135.get(k - j + n - 1) - 1);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        GridIllumination g = new GridIllumination();
        int[][] lamps = {{0, 0}, {4, 4}};
        //Input: n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
        //Output: [1,0]
        System.out.println(Arrays.toString(g.gridIllumination(5, lamps, new int[][]{{1, 1}, {1, 0}})));
        //Input: n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
        //Output: [1,1]
        System.out.println(Arrays.toString(g.gridIllumination(5, lamps, new int[][]{{1, 1}, {1, 1}})));
        //Input: n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
        //Output: [1,1,0]
        System.out.println(Arrays.toString(g.gridIllumination(5, new int[][]{{0, 0}, {0, 4}}, new int[][]{{0, 4}, {0, 1}, {1, 4}})));
        //[1,0,1,1,0,1]
        System.out.println(Arrays.toString(g.gridIllumination(6, new int[][]{{2, 5}, {4, 2}, {0, 3}, {0, 5}, {1, 4}, {4, 2}, {3, 3}, {1, 0}}, new int[][]{{4, 3}, {3, 1}, {5, 3}, {0, 5}, {4, 4}, {3, 3}})));
        System.out.println(Arrays.toString(g.gridIllumination(1, new int[][]{{0, 0}, {0, 0}}, new int[][]{{0, 0}, {0, 0}})));

    }
}
