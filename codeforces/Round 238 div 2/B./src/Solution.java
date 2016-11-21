import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = in.nextInt() - 2;
        out.print(n * n);
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
