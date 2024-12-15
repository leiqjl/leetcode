package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 1792. Maximum Average Pass Ratio - Medium
 */
public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
        double sumRatio = 0;
        for (int[] c : classes) {
            double passes = c[0];
            double total = c[1];
            double ratioChange = ((passes + 1.0) / (total + 1.0) - passes / total);
            maxHeap.offer(new double[]{passes, total, ratioChange});
            sumRatio += passes / total;
        }
        while (extraStudents > 0) {
            double[] poll = maxHeap.poll();
            double passes = poll[0];
            double total = poll[1];
            sumRatio -= passes / total;
            passes++;
            total++;
            double ratioChange = ((passes + 1.0) / (total + 1.0) - passes / total);
            maxHeap.offer(new double[]{passes, total, ratioChange});
            sumRatio += passes / total;
            extraStudents--;
        }
        return sumRatio / classes.length;
    }
}
