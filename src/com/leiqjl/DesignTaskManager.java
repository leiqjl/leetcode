package com.leiqjl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 3408. Design Task Manager - Medium
 */
public class DesignTaskManager {
    class TaskManager {

        //userId, taskId, priority
        private final TreeSet<int[]> taskSet;
        private final Map<Integer, int[]> taskMap;

        public TaskManager(List<List<Integer>> tasks) {
            taskSet = new TreeSet<>((a, b) -> {
                if (a[2] == b[2]) {
                    return b[1] - a[1];
                }
                return b[2] - a[2];
            });
            taskMap = new HashMap<>();
            for (List<Integer> task : tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
                int[] taskArr = {userId, taskId, priority};
                taskSet.add(taskArr);
                taskMap.put(taskId, taskArr);
            }
        }

        public void add(int userId, int taskId, int priority) {
            int[] taskArr = {userId, taskId, priority};
            taskSet.add(taskArr);
            taskMap.put(taskId, taskArr);
        }

        public void edit(int taskId, int newPriority) {
            int[] taskArr = taskMap.get(taskId);
            if (taskArr == null) {
                return;
            }
            taskSet.remove(taskArr);
            taskArr[2] = newPriority;
            taskSet.add(taskArr);
        }

        public void rmv(int taskId) {
            int[] taskArr = taskMap.get(taskId);
            if (taskArr == null) {
                return;
            }
            taskSet.remove(taskArr);
        }

        public int execTop() {
            if (taskSet.isEmpty()) {
                return -1;
            }
            int[] first = taskSet.first();
            taskSet.remove(first);
            taskMap.remove(first[1]);
            return first[0];
        }
    }
}
