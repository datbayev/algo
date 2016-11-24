import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        int[][] a = new int[n][m];
        int[] d = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextInt();

        int ii = 0;
        int maxBear = 0;
        while (ii < n) {
            int jj = 0;
            int max = 0;
            int cur = 0;

            while (jj < m) {
                while (jj < m && a[ii][jj] == 1) {
                    jj++;
                    cur++;
                }

                max = Math.max(max, cur);
            }
            d[ii] = max;

            if (maxBear < d[ii]) {
                maxBear = d[ii];
            }

            ii++;
        }

        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            a[x - 1][y - 1] = 1 - a[x - 1][y - 1];

        }

        out.close();
    }

    public static void main(String[] args) {
        new ProblemB().solve();
    }
}
