package leetcode;

// https://leetcode.com/problems/wildcard-matching/description/
// 44. Wildcard Matching

import java.util.*;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] d = new boolean[s.length() + 1][p.length() + 1];

        d[s.length()][p.length()] = true;

        for (int i = p.length() - 1; i >= 0; i--)
            if (p.charAt(i) != '*')
                break;
            else
                d[s.length()][i] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    d[i][j] = d[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    d[i][j] = d[i + 1][j] || d[i][j + 1];
                else
                    d[i][j] = false;
            }
        }

        return d[0][0];
    }

    public boolean isMatch_BFS(String s, String p) {
        if (p.equals(""))
            return s.equals("");

        if (s.equals(""))
            return stars(p);

        int n = s.length();
        int m = p.length();

        boolean[][] d = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*') {
                    d[i][j] = true;
                }
            }
        }

        ArrayDeque<Integer> qx = new ArrayDeque<>();
        ArrayDeque<Integer> qy = new ArrayDeque<>();

        boolean[][] used = new boolean[n][m];

        qx.add(0);
        qy.add(0);

        used[0][0] = true;

        while (!qx.isEmpty()) {
            int i = qx.pollFirst();
            int j = qy.pollFirst();

            if (i == n - 1) {
                if (j == m - 1)
                    return d[i][j];

                if (stars(p.substring(j + 1)))
                    return true;

                if (p.charAt(j) == '*')
                    add(qx, qy, d, used, i, j + 1);

                continue;
            }

            if (!d[i][j]) // current way is not possible, try next
                continue;

            add(qx, qy, d, used, i + 1, j + 1);

            if (p.charAt(j) == '*') {
                if (j == m - 1)
                    return true;

                add(qx, qy, d, used, i + 1, j);
                add(qx, qy, d, used, i, j + 1);
            }
        }

        return false;
    }

    private boolean stars(String p) {
        for (char c : p.toCharArray())
            if (c != '*')
                return false;

        return true;
    }

    private void add(ArrayDeque<Integer> qx, ArrayDeque<Integer> qy, boolean[][] d, boolean[][] used, int i, int j) {
        if (i >= d.length || j >= d[0].length || used[i][j] || !d[i][j])
            return;

        qx.add(i);
        qy.add(j);
        used[i][j] = true;
    }
}
