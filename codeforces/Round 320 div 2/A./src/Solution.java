import java.io.*;
import java.util.*;

public class Solution {

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int x = in.nextInt();
        int res = 0;
        while (x > 0) {
            int cur = 1;
            while (cur <= x)
                cur = cur * 2;

            if (cur > x)
                cur /= 2;

            x -= cur;
            res++;
        }

        out.print(res);
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
