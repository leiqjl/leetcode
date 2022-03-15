package com.leiqjl;

/**
 * 277. Find the Celebrity - Medium
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n).
 * There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party.
 * If there is no celebrity, return -1.
 */
public class FindTheCelebrity {
    /**
     * Input: graph = [
     * [1,1,0],
     * [0,1,0],
     * [1,1,1]
     * ]
     * Output: 1
     * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j.
     * The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
     */
    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }
        int celebrity = 0;
        int i = 1;
        while (i < n) {
            if ((knows(celebrity, i) && knows(i, celebrity)) || (!knows(celebrity, i) && !knows(i, celebrity))) {
                celebrity = i + 1;
                i = i + 2;
            } else if (knows(celebrity, i) && !knows(i, celebrity)) {
                celebrity = i;
                i++;
            } else {
                // !knows(celebrity, i) && knows(i, celebrity)
                i++;
            }
        }
        if (celebrity >= n) {
            return -1;
        }
        for (int other = 0; other < n; other++) {
            if (celebrity == other) {
                continue;
            }
            if (!(!knows(celebrity, other)&& knows(other, celebrity))) {
                return -1;
            }
        }
        return celebrity;
    }

    int[][] graph;

    private boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }

    public FindTheCelebrity(int[][] graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        FindTheCelebrity f = new FindTheCelebrity(graph);
        int celebrity = f.findCelebrity(3);
        System.out.println(celebrity);
        //Input: graph = [
        //  [1,0,1],
        //  [1,1,0],
        //  [0,1,1]
        //]
        //Output: -1
        //Explanation: There is no celebrity.
        int[][] graph1 = new int[][]{{1,0,1}, {1, 1, 0}, {0, 1, 1}};
        FindTheCelebrity f1 = new FindTheCelebrity(graph1);
        int celebrity1 = f1.findCelebrity(3);
        System.out.println(celebrity1);
    }
}
