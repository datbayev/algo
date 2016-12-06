import java.io.*;
import java.util.*;

public class BetweenTwoSets {
    public static void main(String[] args) {
        new BetweenTwoSets().solve();
    }

    public static int GCD(int p, int q) {
        if (q == 0) return p;

        int r = p % q;
        return GCD(q, r);
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[m];

        x[0] = in.nextInt();
        int lcm = x[0];
        for (int i = 1; i < n; i++) {
            x[i] = in.nextInt();
            lcm = LCM(Math.max(lcm, x[i]), Math.min(lcm, x[i]));
        }

        y[0] = in.nextInt();
        int gcd = y[0];
        for (int i = 1; i < m; i++) {
            y[i] = in.nextInt();
            gcd = GCD(Math.max(gcd, y[i]), Math.min(gcd, y[i]));
        }

        if (gcd % lcm != 0) {
            out.print(0);
            out.close();
            return;
        }

        int res = 0;

        for (int i = lcm; i <= gcd; i++) {
            if (i % lcm == 0 && gcd % i == 0)
                res++;
        }

        out.print(res);
        out.close();
    }
}
