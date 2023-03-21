package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1376. Time Needed to Inform All Employees - medium
 */
public class TimeNeededToInformAllEmployees {
    //1 <= n <= 10^5
    //0 <= headID < n
    //manager.length == n
    //0 <= manager[i] < n
    //manager[headID] == -1
    //informTime.length == n
    //0 <= informTime[i] <= 1000
    //informTime[i] == 0 if employee i has no subordinates.
    //It is guaranteed that all the employees can be informed.
    public int numOfMinutes1(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            graph.computeIfAbsent(manager[i], v -> new ArrayList<>()).add(i);
        }
        return numOfMinutes(headID, 0, informTime, graph);
    }

    private int numOfMinutes(int s, int time, int[] informTime, Map<Integer, List<Integer>> graph) {
        int max = time;
        if (graph.containsKey(s)) {
            for (int v : graph.get(s)) {
                max = Math.max(max, numOfMinutes(v, time + informTime[s], informTime, graph));
            }
        }
        return max;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (informTime[i] == 0) {
                continue;
            }
            max = Math.max(max, dfs(i, manager, informTime));
        }
        return max;
    }

    private int dfs(int s, int[] manager, int[] informTime) {
        if (manager[s] != -1) {
            informTime[s] += dfs(manager[s], manager, informTime);
            manager[s] = -1;
        }
        return informTime[s];
    }

    public static void main(String[] args) {
        TimeNeededToInformAllEmployees t = new TimeNeededToInformAllEmployees();
        assert t.numOfMinutes(1, 0, new int[]{-1}, new int[]{0}) == 0;
        assert t.numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}) == 1;
    }
}
