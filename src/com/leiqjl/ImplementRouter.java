package com.leiqjl;

import java.util.*;

/**
 * 3508. Implement Router - Medium
 */
public class ImplementRouter {
    //2 <= memoryLimit <= 10^5
    //1 <= source, destination <= 2 * 10^5
    //1 <= timestamp <= 10^9
    //1 <= startTime <= endTime <= 10^9
    //At most 10^5 calls will be made to addPacket, forwardPacket, and getCount methods altogether.
    //queries for addPacket will be made in increasing order of timestamp.
    class Router {
        private int limit;

        //destination  timestamp
        private Map<Integer, List<Integer>> countMap;
        private final Set<Long> seen;
        private final Deque<int[]> deque;


        public Router(int memoryLimit) {
            this.limit = memoryLimit;
            seen = new HashSet<>();
            deque = new ArrayDeque<>(memoryLimit);
            countMap = new HashMap<>();
        }

        private long getKey(int source, int destination, int timestamp) {
            return (long) source << 49 | (long) destination << 19 | timestamp;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            long key = getKey(source, destination, timestamp);
            if (seen.contains(key)) {
                return false;
            }
            if (deque.size() == limit) {
                forwardPacket();
            }
            seen.add(key);
            deque.offer(new int[]{source, destination, timestamp});
            countMap.putIfAbsent(destination, new ArrayList<>());
            countMap.get(destination).add(timestamp);
            return true;
        }

        public int[] forwardPacket() {
            if (deque.isEmpty()) {
                return new int[]{};
            }
            int[] poll = deque.poll();
            seen.remove(getKey(poll[0], poll[1], poll[2]));
            countMap.get(poll[1]).remove(0);
            return poll;
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> list = countMap.get(destination);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            int l = lowerBound(list, startTime);
            int r = upperBound(list, endTime);
            return r - l;
        }

        // >= target
        private int lowerBound(List<Integer> list, int target) {
            int lo = 0, hi = list.size();
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (list.get(mid) < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }


        // > target
        private int upperBound(List<Integer> list, int target) {
            int lo = 0, hi = list.size();
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (list.get(mid) <= target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
