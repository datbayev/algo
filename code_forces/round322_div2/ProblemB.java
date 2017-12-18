package code_forces.round322_div2;

import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] h = new int[n + 1];
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++)
            h[i] = in.nextInt();

        int max = h[n];
        res[n] = 0;
        for (int i = n - 1; i > 0; i--) {
            if (max < h[i]) {
                res[i] = 0;
                max = h[i];
            } else {
                res[i] = max - h[i] + 1;
            }
        }

        for (int i = 1; i <= n; i++)
            out.print(res[i] + " ");

        out.close();
    }
}
