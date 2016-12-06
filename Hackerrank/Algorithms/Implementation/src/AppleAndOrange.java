import java.io.*;
import java.util.*;

public class AppleAndOrange {
    public static void main(String[] args) {
        new AppleAndOrange().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int s = in.nextInt();
        int t = in.nextInt();

        int a = in.nextInt();
        int b = in.nextInt();

        int m = in.nextInt();
        int n = in.nextInt();

        List<Integer> apples = new ArrayList<>();
        List<Integer> oranges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int cur = in.nextInt();
            if (cur > 0 && cur + a >= s && cur + a <= t)
                apples.add(cur);
        }

        for (int i = 0; i < n; i++) {
            int cur = in.nextInt();
            if (cur < 0 && b + cur >= s && b + cur <= t)
                oranges.add(cur);
        }

        out.println(apples.size());
        out.println(oranges.size());

        out.close();
    }
}
