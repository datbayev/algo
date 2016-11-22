import java.util.*;
import java.io.*;

public class Solution {

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int size = 5;
        int[] m = new int[size];
        int[] w = new int[size];
        int[] p = {500, 1000, 1500, 2000, 2500};

        for (int i = 0; i < size; i++)
            m[i] = in.nextInt();

        for (int i = 0; i < size; i++)
            w[i] = in.nextInt();

        int hs = in.nextInt();
        int hu = in.nextInt();

        int total = hs * 100 - hu * 50;

        for (int i = 0; i < size; i++) {
            int v1 = p[i] * 3 / 10;
            int v2 = (250 - m[i]) * p[i] / 250 - 50 * w[i];
            total += Math.max(v1, v2);
        }

        out.print(total);
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
