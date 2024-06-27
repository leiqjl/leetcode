package com.leiqjl;

/**
 * 1791. Find Center of Star Graph - Easy
 */
public class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }
}
