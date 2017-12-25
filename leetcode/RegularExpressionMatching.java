package leetcode;

// https://leetcode.com/problems/regular-expression-matching/description/
// 10. Regular Expression Matching

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 0; j < m; j++)
            if (p.charAt(j) == '*' && dp[0][j - 1])
                dp[0][j + 1] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p.charAt(j) == '.')
                    dp[i + 1][j + 1] = dp[i][j];

                if (s.charAt(i) == p.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];

                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
