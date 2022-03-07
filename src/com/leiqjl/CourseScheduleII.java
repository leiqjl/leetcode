package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 210. Course Schedule II - Medium
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * - For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {

    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        int[] result = new int[numCourses];
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
            result[count++] = s;
            for (int i : graph[s]) {
                degree[i]--;
                if (degree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }

    //DFS
    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
        }
        Deque<Integer> stack = new ArrayDeque<>(numCourses);
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(graph, i, stack, visit)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean canFinish(LinkedList<Integer>[] graph, int s, Deque<Integer> stack, int[] visit) {
        if (visit[s] == 2) {
            return false;
        }
        if (visit[s] == 1) {
            return true;
        }
        visit[s] = 2;
        for (int i : graph[s]) {
            if (!canFinish(graph, i, stack, visit)) {
                return false;
            }
        }
        stack.push(s);
        visit[s] = 1;
        return true;
    }
}
