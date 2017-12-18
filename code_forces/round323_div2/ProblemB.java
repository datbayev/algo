package code_forces.round323_div2;

import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        int res = 0;
        int collected = 0;

        int left = 0;
        int right = n - 1;
        int dir = 1;
        Set<Integer> used = new HashSet<Integer>();

        while (collected < n) {
            if (dir == 1) {
                for (int i = left; i <= right; i++)
                    if (!used.contains(i) && a[i] <= collected) {
                        collected++;
                        used.add(i);
                    }
            } else {
                for (int i = right; i >= left; i--) {
                    if (!used.contains(i) && a[i] <= collected) {
                        collected++;
                        used.add(i);
                    }
                }
            }
            dir = 1 - dir;
            res++;
        }

        out.print(res - 1);
        out.close();
    }

    public static void main(String[] args) {
        new code_forces.round305_div2.ProblemB().solve();
    }
}
