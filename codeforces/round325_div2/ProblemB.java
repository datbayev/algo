package codeforces.round325_div2;

import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int[] c = new int[n];
        int minSum = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) a1[i] = in.nextInt();
        for (int i = 1; i < n; i++) a2[i] = in.nextInt();

        for (int i = 0; i < n; i++)
            c[i] = in.nextInt();

        for (int l = 0; l < n; l++) {
            for (int r = 0; r < n; r++) {
                if (l != r) {
                    int res = c[l] + c[r];

                    for (int i = 1; i < l; i++) res += a1[i];
                    for (int i = l; i < n; i++) res += a2[i];

                    for (int i = r; i < n; i++) res += a1[i];
                    for (int i = 1; i < r; i++) res += a2[i];

                    minSum = Math.min(minSum, res);
                }
            }
        }

        out.print(minSum);
        out.close();
    }
}
