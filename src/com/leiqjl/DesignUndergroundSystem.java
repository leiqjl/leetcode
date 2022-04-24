package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1396. Design Underground System - Medium
 */
public class DesignUndergroundSystem {

    class UndergroundSystem {
        class Pair<K, V> {
            K k;
            V v;

            public Pair(K k, V v) {
                this.k = k;
                this.v = v;
            }

            public K getK() {
                return k;
            }

            public V getV() {
                return v;
            }

            public void setK(K k) {
                this.k = k;
            }

            public void setV(V v) {
                this.v = v;
            }
        }
        private Map<Integer, Pair<String, Integer>> checkIn;
        private Map<String, Pair<Integer, Integer>> totalTimeMap;

        public UndergroundSystem() {
            checkIn = new HashMap<>();
            totalTimeMap = new HashMap<>();
        }

        //A customer with a card ID equal to id, checks in at the station stationName at time t.
        //A customer can only be checked into one place at a time.
        public void checkIn(int id, String stationName, int t) {
            checkIn.put(id, new Pair<>(stationName, t));
        }

        //A customer with a card ID equal to id, checks out from the station stationName at time t.
        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> pair = checkIn.get(id);
            String key = pair.getK() + "-" + stationName;
            int time = t - pair.getV();
            Pair<Integer, Integer> total = totalTimeMap.get(key);
            if (total == null) {
                total = new Pair<>(time, 1);
            } else {
                total.setK(total.getK() + time);
                total.setV(total.getV() + 1);
            }
            totalTimeMap.put(key, total);
        }

        //Returns the average time it takes to travel from startStation to endStation.
        //The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
        //The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
        //There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "-" + endStation;
            Pair<Integer, Integer> pair = totalTimeMap.get(key);
            return (double)pair.getK()/pair.getV();
        }
    }
}
