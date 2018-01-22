package leetcode;

// https://leetcode.com/problems/course-schedule-ii/description/
// 210. Course Schedule II

import java.util.*;

public class CourseScheduleII_DFS {
    Map<Integer, List<Integer>> graph;
    boolean[] inProgress;
    Set<Integer> out;
    boolean[] used;
    int[] path;
    int counter;

    boolean noSolution;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        out = new HashSet();
        graph = new HashMap();
        path = new int[numCourses];
        used = new boolean[numCourses];
        inProgress = new boolean[numCourses];
        counter = numCourses - 1;

        noSolution = false;

        if (numCourses == 0)
            return new int[0];

        for (int i = 0; i < numCourses; i++)
            out.add(i);

        int m = prerequisites.length;

        for (int i = 0; i < m; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            if (!graph.containsKey(prereq))
                graph.put(prereq, new ArrayList());

            graph.get(prereq).add(course);
            out.remove(course);
        }

        Iterator<Integer> it = out.iterator();
        while (it.hasNext()) {
            int v = it.next();
            dfs(v);
        }

        if (noSolution || counter > 0)
            return new int[0];

        return path;
    }

    private void dfs(int v) {
        used[v] = true;
        inProgress[v] = true;

        List<Integer> list = graph.get(v);
        if (list != null) {
            for (int x : list) {
                if (inProgress[x]) {
                    noSolution = true;
                    return;
                }

                if (!used[x])
                    dfs(x);

                if (noSolution)
                    return;
            }
        }

        inProgress[v] = false;
        path[counter--] = v;
    }
}
