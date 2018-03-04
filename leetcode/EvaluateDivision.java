package leetcode;

// https://leetcode.com/problems/evaluate-division/description/
// 399. Evaluate Division

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> g = new HashMap<>();
        int n = equations.length;
        int m = queries.length;

        double[] res = new double[m];

        for (int i = 0; i < n; i++) {
            String x = equations[i][0];
            String y = equations[i][1];
            double val = values[i];

            if (!g.containsKey(x)) g.put(x, new ArrayList<>());
            if (!g.containsKey(y)) g.put(y, new ArrayList<>());

            g.get(x).add(new Edge(y, val)); // x is val times more than y
            g.get(y).add(new Edge(x, 1.0 / val));
        }

        for (int i = 0; i < m; i++) {
            double cur = bfs(queries[i][0], queries[i][1], g);
            res[i] = cur;
        }

        return res;
    }

    private double bfs(String start, String end, Map<String, List<Edge>> g) {
        if (!g.containsKey(start) || !g.containsKey(end))
            return -1.0;

        if (start.equals(end))
            return 1.0;

        ArrayDeque<String> q = new ArrayDeque<>();
        Map<String, Double> map = new HashMap<>();
        Set<String> used = new HashSet<>();

        used.add(start);
        q.add(start);
        map.put(start, 1.0); // start/start = 1.0

        while (!q.isEmpty()) {
            String cur = q.pollFirst();

            List<Edge> list = g.get(cur); // list of current connections
            for (Edge edge : list) {

                if (used.contains(edge.v))
                    continue;

                double ratio = map.get(cur) * edge.val;

                if (edge.v.equals(end))
                    return ratio;

                q.add(edge.v);
                map.put(edge.v, ratio);
            }
        }

        return -1.0;
    }

    class Edge {
        String v;
        double val;

        Edge(String v, double val) {
            this.v = v;
            this.val = val;
        }
    }
}
