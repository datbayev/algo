package leetcode;

// https://leetcode.com/problems/all-paths-from-source-to-target/description/
// 797. All Paths From Source to Target

import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!g.containsKey(i))
                g.put(i, new ArrayList<>());

            for (int j = 0; j < graph[i].length; j++)
                g.get(i).add(graph[i][j]);
        }

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();

        path.add(0);
        used[0] = true;

        dfs(0, n - 1, used, g, path, res);

        return res;
    }

    private void dfs(int v, int end, boolean[] used, Map<Integer, List<Integer>> g, List<Integer> path, List<List<Integer>> res) {
        if (v == end) {
            res.add(new ArrayList<>(path));
            return;
        }

        List<Integer> next = g.get(v);
        if (next == null)
            return;

        for (int x : next) {
            if (!used[x]) {
                used[x] = true;
                path.add(x);
                dfs(x, end, used, g, path, res);
                path.remove(path.size() - 1);
                used[x] = false;
            }
        }
    }
}
