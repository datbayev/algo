package leetcode;

// https://leetcode.com/problems/course-schedule/description/
// 207. Course Schedule

import java.util.*;

public class CourseSchedule {
    private boolean success = true;

    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] mark = new int[n]; // 0 - white, 1 - grey, 2 - black

        for (int[] edge : prerequisites) {
            int v1 = edge[0];
            int v2 = edge[1];

            if (!g.containsKey(v1))
                g.put(v1, new ArrayList<>());

            g.get(v1).add(v2); // to finish v1, first you need to finish v2
        }

        for (int i = 0; i < n; i++) {
            if (mark[i] == 0)
                dfs(i, mark, g);
        }

        return success;
    }

    private void dfs(int v, int[] mark, Map<Integer, List<Integer>> g) {
        mark[v] = 1; // mark as grey, in progress

        List<Integer> list = g.get(v);
        if (list != null) {
            for (int x : list) {
                if (mark[x] == 1) {
                    success = false;
                    return;
                } else if (mark[x] == 0) // white vertex, was not learned yet
                    dfs(x, mark, g);

                if (!success)
                    return;
            }
        }

        mark[v] = 2; // mark as black, finished learning
    }
}
