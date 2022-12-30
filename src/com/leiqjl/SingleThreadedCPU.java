package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1834. Single-Threaded CPU - Medium
 */
public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? Integer.compare(a[2], b[2]) : Integer.compare(a[1], b[1])));
        int[] result = new int[n];
        int curTime = 0, taskIndex = 0, resultIndex = 0;
        while (!minHeap.isEmpty() || taskIndex < n) {
            if (minHeap.isEmpty() && curTime < sortedTasks[taskIndex][0]) {
                curTime = sortedTasks[taskIndex][0];
            }

            while (taskIndex < n && curTime >= sortedTasks[taskIndex][0]) {
                minHeap.add(sortedTasks[taskIndex]);
                taskIndex++;
            }

            curTime += minHeap.peek()[1];
            result[resultIndex++] = minHeap.peek()[2];
            minHeap.remove();
        }
        return result;
    }
}
