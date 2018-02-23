package leetcode;

// https://leetcode.com/problems/unique-paths/description/
// 62. Unique Paths

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        long[][] d = new long[m][n];
        d[0][0] = 1;
        for (int i = 1; i < m; i++)
            d[i][0] = 1;

        for (int i = 1; i < n; i++)
            d[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                d[i][j] = d[i - 1][j] + d[i][j - 1];

        return (int)d[m - 1][n - 1];
    }
}
