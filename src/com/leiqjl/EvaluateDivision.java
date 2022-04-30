package com.leiqjl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division - Medium
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!graph.containsKey(a)) {
                graph.put(a, new HashMap<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new HashMap<>());
            }
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double res = dfs(query.get(0), query.get(1), graph, new HashSet<>(), 1.0);
            result[i] = res == 0.0 ? -1.0 : res;
        }
        return result;
    }

    private double dfs(String begin, String end, HashMap<String, HashMap<String, Double>> graph, HashSet<String> set, double value) {
        if (set.contains(begin) || !graph.containsKey(begin)) {
            return 0.0;
        }
        if (begin.equals(end)) {
            return value;
        }
        set.add(begin);
        HashMap<String, Double> edges = graph.get(begin);
        double temp = 0.0;

        for (Map.Entry<String, Double> edge : edges.entrySet()) {
            temp = dfs(edge.getKey(), end, graph, set, edge.getValue() * value);
            if (temp != 0.0) {
                break;
            }
        }
        return temp;
    }
}
