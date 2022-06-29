package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1345. Jump Game IV - Hard
 * <p>
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * In one step you can jump from index i to index:
 * - i + 1 where: i + 1 < arr.length.
 * - i - 1 where: i - 1 >= 0.
 * - j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 */
public class JumpGameIV {

    public int minJumps(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        int jump = 0;
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int s = q.remove();
                if (s == n - 1) {
                    return jump;
                }
                LinkedList<Integer> list = map.get(arr[s]);
                list.add(s - 1);
                list.add(s + 1);
                for (int v : list) {
                    if (v >= 0 && v < n && !visited[v]) {
                        visited[v] = true;
                        q.add(v);
                    }
                }
                list.clear();
                size--;
            }
            jump++;
        }
        return 0;
    }

    public static void main(String[] args) {
        JumpGameIV j = new JumpGameIV();
        //Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
        //Output: 3
        //Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        assert j.minJumps(arr) == 3;
        //Input: arr = [7]
        //Output: 0
        //Explanation: Start index is the last index. You do not need to jump.
        int[] arr1 = {7};
        assert j.minJumps(arr1) == 0;
        //Input: arr = [7,6,9,6,9,6,9,7]
        //Output: 1
        //Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
        int[] arr2 = {7, 6, 9, 6, 9, 6, 9, 7};
        assert j.minJumps(arr2) == 1;
    }
}
