import java.io.*;
import java.util.*;

public class ProblemB {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    private String next() throws Exception {
        if (st == null || !st.hasMoreElements())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    private int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    public void solve() throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int n = nextInt();
        int m = nextInt();

        StringBuilder s = new StringBuilder(next());

        int[] res = new int[60];
        int[] pos = new int[60];
        for (int i = 0; i < 60; i++) {
            res[i] = i;
            pos[i] = i;
        }

        for (int i = 0; i < m; i++) {
            char c1 = next().charAt(0);
            char c2 = next().charAt(0);

            if (c1 == c2)
                continue;

            int temp = pos[c1 - 97];
            pos[c1 - 97] = pos[c2 - 97];
            pos[c2 - 97] = temp;

            res[pos[c1 - 97]] = c1 - 97;
            res[pos[c2 - 97]] = c2 - 97;
        }

        for (int i = 0; i < n; i++)
            out.print((char)(res[s.charAt(i) - 97] + 97));
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new ProblemB().solve();
    }
}
