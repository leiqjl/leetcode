package com.leiqjl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 207. Course Schedule - Medium
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * - For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            count ++;
            for (int i : graph[s]) {
                degree[i]--;
                if (degree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return count == numCourses;
    }

}
