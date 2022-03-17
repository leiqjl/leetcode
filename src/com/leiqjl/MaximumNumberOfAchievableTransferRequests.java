package com.leiqjl;

/**
 * 1601. Maximum Number of Achievable Transfer Requests - Hard
 */
public class MaximumNumberOfAchievableTransferRequests {
    int max = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] count = new int[n];
        recurse(requests, 0, count, 0);
        return max;
    }

    private void recurse(int[][] requests, int idx, int[] count, int num) {
        if (idx == requests.length) {
            for (int c : count) {
                if (c != 0) {
                    return;
                }
            }
            if (num > max) {
                max = num;
            }
            return;
        }
        if (requests[idx][0] == requests[idx][1]) {
            recurse(requests, idx + 1, count, num + 1);
            return;
        }

        count[requests[idx][0]]--;
        count[requests[idx][1]]++;
        recurse(requests, idx + 1, count, num + 1);

        count[requests[idx][0]]++;
        count[requests[idx][1]]--;
        recurse(requests, idx + 1, count, num);
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 2}, {2, 1}};
        MaximumNumberOfAchievableTransferRequests m = new MaximumNumberOfAchievableTransferRequests();
        assert m.maximumRequests(3, a) == 3;

        int[][] a1 = {{1, 2}, {1, 2}, {2, 2}, {0, 2}, {2, 1}, {1, 1}, {1, 2}};
        assert m.maximumRequests(3, a1) == 4;
    }
}
