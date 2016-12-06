import java.io.*;
import java.util.*;

public class Kangaroo {
    public static void main(String[] args) {
        new Kangaroo().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        boolean found = false;

        while (true) {
            if (x1 == x2) {
                found = true;
                break;
            }

            x1 += v1;
            x2 += v2;

            if (x1 > x2)
                break;
        }

        out.print(found ? "YES" : "NO");
        out.close();
    }
}
