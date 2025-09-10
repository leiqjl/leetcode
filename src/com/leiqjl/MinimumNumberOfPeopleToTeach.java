package com.leiqjl;

import java.util.HashSet;
import java.util.Set;

/**
 * 1733. Minimum Number of People to Teach - Medium
 */
public class MinimumNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        int[] freq = new int[n + 1];
        Set<Integer> needTeachSet = new HashSet<>();
        int maxFreq = 0;
        for (int[] f : friendships) {
            int a = f[0] - 1;
            int b = f[1] - 1;
            if (!hasIntersection(languages[a], languages[b])) {

                if (needTeachSet.add(a)) {
                    for (int l : languages[a]) {
                        freq[l]++;
                        maxFreq = Math.max(maxFreq, freq[l]);
                    }
                }
                if (needTeachSet.add(b)) {
                    for (int l : languages[b]) {
                        freq[l]++;
                        maxFreq = Math.max(maxFreq, freq[l]);
                    }
                }
            }
        }
        return needTeachSet.size() - maxFreq;
    }

    private boolean hasIntersection(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : a) {
            set.add(val);
        }
        for (int val : b) {
            if (set.contains(val)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumNumberOfPeopleToTeach m = new MinimumNumberOfPeopleToTeach();
        //Input: n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
        //Output: 1
        //Explanation: You can either teach user 1 the second language or user 2 the first language.
        assert m.minimumTeachings(2, new int[][]{{1}, {2}, {1, 2}}, new int[][]{{1, 2}, {1, 3}, {2, 3}}) == 1;

        //Input: n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
        //Output: 2
        //Explanation: Teach the third language to users 1 and 3, yielding two users to teach.
        assert m.minimumTeachings(3, new int[][]{{2}, {1, 3}, {1, 2}, {3}}, new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}}) == 2;
    }
}
