package com.leiqjl;

import java.util.Arrays;

/**
 * 706. Design HashMap - Easy
 */
public class DesignHashMap {

    class MyHashMap {
        int[][] map;

        public MyHashMap() {
            map = new int[1001][];
        }

        public void put(int key, int value) {
            int idx = key / 1000;
            if (map[idx] == null) {
                map[idx] = new int[1001];
                Arrays.fill(map[idx], -1);
            }
            int offset = key % 1000;
            map[idx][offset] = value;
        }

        public int get(int key) {
            int idx = key / 1000;
            if (map[idx] == null) {
                return -1;
            }
            int offset = key % 1000;
            return map[idx][offset];
        }

        public void remove(int key) {
            int idx = key / 1000;
            if (map[idx] == null) {
                return;
            }
            int offset = key % 1000;
            map[idx][offset] = -1;
        }
    }
}
