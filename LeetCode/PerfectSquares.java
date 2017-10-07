// https://leetcode.com/problems/perfect-squares
// 279. Perfect Squares

import java.io.PrintWriter;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++)
            dp[i] = 100000;

        for (int i = 0; i <= n; i++)
            for (int j = 1; i + j * j <= n; j++)
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);

        return dp[n];
    }

    public static void main(String[] args) {
        new PerfectSquares().solve();
    }

    public void solve() {
        PrintWriter out = new PrintWriter(System.out);
        int n = 13;
        int res = numSquares(n);
        out.print(res);
        out.close();
    }
}
