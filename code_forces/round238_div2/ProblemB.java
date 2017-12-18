package code_forces.round238_div2;

import java.io.*;
import java.util.*;

public class ProblemB {
    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = in.nextInt() - 2;
        out.print(n * n);
        out.close();
    }

    public static void main(String[] args) {
        new code_forces.round305_div2.ProblemB().solve();
    }
}