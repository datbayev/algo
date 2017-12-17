package codeforces.round323_div2;

import java.util.*;
import java.io.*;

public class ProblemA {

    public class Intersection {
        int x;
        int y;

        public Intersection(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        Set<Integer> xx = new HashSet<Integer>();
        Set<Integer> yy = new HashSet<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        List<Intersection> roads = new ArrayList<Intersection>();

        for (int i = 0; i < n * n; i++)
            roads.add(new Intersection(in.nextInt(), in.nextInt()));

        for (int i = 0; i < n * n; i++) {
            Intersection cur = roads.get(i);
            if (!xx.contains(cur.x) && !yy.contains(cur.y)) {
                res.add(i + 1);
                xx.add(cur.x);
                yy.add(cur.y);
            }
        }

        for (int i = 0; i < res.size(); i++)
            out.print(res.get(i) + " ");

        out.close();
    }

    public static void main(String[] args) {
        new codeforces.round305_div2.ProblemA().solve();
    }
}
