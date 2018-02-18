package leetcode;

// https://leetcode.com/problems/is-graph-bipartite/description/
// 785. Is Graph Bipartite?

public class IsGraphBipartite {
    private int[] colors;
    private boolean possible = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new int[n];

        for (int i = 0; i < n; i++)
            colors[i] = -1; // -1 unused, 0 - group A, 1 - group B

        for (int i = 0; i < n; i++)
            if (colors[i] == -1)
                dfs(i, i % 2, graph);

        for (int i = 0; i < n; i++)
            if (colors[i] == -1)
                return false;

        return possible;
    }

    private void dfs(int v, int color, int[][] graph) {
        if (!possible)
            return;

        if (colors[v] == -1)
            colors[v] = color;
        else if (colors[v] == 1 - color) {
            possible = false;
            return;
        }

        for (int i = 0; i < graph[v].length; i++) { // v's connections
            if (colors[graph[v][i]] == -1)
                dfs(graph[v][i], 1 - color, graph);
            else if (colors[graph[v][i]] == color) {
                possible = false;
                return;
            }
        }
    }
}
