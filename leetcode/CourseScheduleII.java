package leetcode;

// https://leetcode.com/problems/course-schedule-ii/description/
// 210. Course Schedule II

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> out = new HashSet();
        Map<Integer, List<Integer>> graph = new HashMap();
        Map<Integer, Set<Integer>> dep = new HashMap();
        Set<String> edges = new HashSet();

        for (int i = 0; i < numCourses; i++)
            out.add(i);

        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];

            if (edges.contains(hash(from, to)))
                continue;
            edges.add(hash(from, to));

            if (!graph.containsKey(from))
                graph.put(from, new ArrayList());
            graph.get(from).add(to);

            if (!dep.containsKey(to))
                dep.put(to, new HashSet());
            dep.get(to).add(from);

            out.remove(to);
        }

        if (out.isEmpty())
            return new int[0];

        Iterator<Integer> it = out.iterator();
        Queue<Integer> q = new LinkedList();

        while (it.hasNext()) {
            int cur = it.next();
            q.add(cur);
        }

        int count = 0;
        int[] path = new int[numCourses];
        boolean[] used = new boolean[numCourses];

        while (!q.isEmpty()) {
            int v = q.poll();
            used[v] = true;
            path[count++] = v;

            if (count == numCourses)
                return path;

            List<Integer> list = graph.get(v);

            if (list != null) {
                for (int x : list) {
                    if (dep.containsKey(x))
                        dep.get(x).remove(v);

                    if (!used[x] && (!dep.containsKey(x) || dep.get(x).isEmpty()))
                        q.add(x);
                }
            }
        }

        return new int[0];
    }

    private String hash(int x1, int x2) {
        return String.format("%d-%d", x1, x2);
    }
}
