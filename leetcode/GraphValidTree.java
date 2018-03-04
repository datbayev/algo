package leetcode;

// https://leetcode.com/problems/graph-valid-tree/description/
// 261. Graph Valid Tree

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n < 2)
            return true;

        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];

            if (!g.containsKey(v1)) g.put(v1, new ArrayList<>());
            if (!g.containsKey(v2)) g.put(v2, new ArrayList<>());

            g.get(v1).add(v2);
            g.get(v2).add(v1);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] used = new boolean[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++)
            p[i] = -1;

        q.add(0);

        int total = 1;
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            used[cur] = true;

            List<Integer> list = g.get(cur);
            if (list == null)
                return false;

            for (int x : list) {
                if (!used[x]) {
                    p[x] = cur;
                    q.add(x);
                    total++;
                } else {
                    if (p[cur] != x)
                        return false;
                }
            }
        }

        return total == n;
    }
}
