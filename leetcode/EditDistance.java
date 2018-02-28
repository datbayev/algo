package leetcode;

// https://leetcode.com/problems/edit-distance/description/
// 72. Edit Distance

public class EditDistance {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // dp[i][j] - answer for first i chars from s1 and first j chars from s2

        for (int i = 1; i <= n; i++)
            dp[i][0] = i; // empty string to i len string - need to add i chars

        for (int j = 1; j <= m; j++)
            dp[0][j] = j; // empty string to j len string - need to add j chars

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

        return dp[n][m];
    }
}
