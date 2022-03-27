package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 1337. The K Weakest Rows in a Matrix - Easy
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]));
        for (int i = 0; i < mat.length; i++) {
            maxHeap.add(new int[]{numsOfOne(mat[i]), i});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = maxHeap.poll()[1];
        }
        return res;
    }

    private int numsOfOne(int[] matRow) {
        int begin = 0, end = matRow.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (matRow[mid] == 1) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin;
    }
}
