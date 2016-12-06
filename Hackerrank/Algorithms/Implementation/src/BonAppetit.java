import java.io.*;
import java.util.*;

public class BonAppetit {
    public static void main(String[] args) {
        new BonAppetit().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];

        int total = 0;
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
            total += c[i];
        }

        int charged = in.nextInt();
        if ((total - c[k]) / 2 == charged)
            out.print("Bon Appetit");
        else
            out.print(charged - (total - c[k]) / 2);

        out.close();
    }
}
