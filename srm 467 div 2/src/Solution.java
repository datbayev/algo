import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public int calculate(int k, int n) {
        int[][] s = new int[k + 1][n + 1];

        for (int i = 0; i <= n; i++)
            s[0][i] = i;

        for (int kk = 1; kk <= k; kk++) {
            for (int nn = 1; nn <= n; nn++) {
                for (int i = 1; i <= nn; i++)
                    s[kk][nn] += s[kk - 1][i];
            }
        }

        return s[k][n];
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int k = in.nextInt();
        int n = in.nextInt();

        int res = calculate(k, n);
        out.print(res);

        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
