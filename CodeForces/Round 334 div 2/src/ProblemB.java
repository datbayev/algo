import java.util.*;
import java.io.*;

public class ProblemB {

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] s = new int[n];

        for (int i = 0; i < n; i++)
            s[i] = in.nextInt();

        int max = s[n - 1];

        int indRight = n - k;
        int indLeft = n - k - 1;

        while (indLeft >= 0 && indLeft < n) {
            max = Math.max(max, s[indLeft] + s[indRight]);
            indLeft--;
            indRight++;
        }

        out.print(max);
        out.close();
    }

    public static void main(String[] args) {
        new ProblemB().solve();
    }
}
