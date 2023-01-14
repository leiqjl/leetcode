package com.leiqjl;

/**
 * 1061. Lexicographically Smallest Equivalent String - Medium
 */
public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', parent);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char) (find(baseStr.charAt(i)-'a',parent)+'a'));
        }
        return sb.toString();
    }

    private void union(int p, int q, int[] parent) {
        int rootP = find(p, parent);
        int rootQ = find(q, parent);
        if (rootP == rootQ) {
            return;
        }
        if (rootP < rootQ) {
            parent[rootQ] = rootP;
        } else {
            parent[rootP] = rootQ;
        }
    }

    public int find(int x, int[] parent) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }
}
