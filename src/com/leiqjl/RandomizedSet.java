package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 */
public class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        if (idx < list.size() - 1) {
            int lastVal = list.getLast();
            list.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        map.remove(val);
        list.removeLast();
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
