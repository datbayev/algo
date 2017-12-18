package codeforces.round305_div2;

import java.io.PrintWriter;
import java.util.*;

public class ProblemA {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }

    public boolean isMultyPal(String s, int k) {
        if (s.length() % k > 0)
            return false;

        int num = s.length() / k;

        while (s.length() > 0) {
            String curString = s.substring(0, num);
            if (!isPalindrome(curString))
                return false;
            s = s.substring(num);
        }

        return true;
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = in.next();
        int k = in.nextInt();

        boolean res = isMultyPal(s, k);
        out.print(res ? "YES" : "NO");
        out.close();
    }

    public static void main(String[] args) {
        new ProblemA().solve();
    }
}
