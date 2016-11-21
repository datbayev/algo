import java.io.PrintWriter;
import java.util.*;

public class Solution {

    static int[] a = new int[100];
    static int[] b = new int[100];

    static int total;
    static int needed;

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        total = n;
        needed = in.nextInt();
        rec(0, 0);

        out.close();
    }

    public static void rec(int startIdx, int included) {
        if (needed == included) {
            for (int i = 0; i < needed; i++)
                System.out.print(b[i] + " ");
            System.out.println();
            return;
        }

        // boundary case
        if (startIdx >= total)
            return;

        // skip, don't include
        rec(startIdx + 1, included);

        // pick a new element
        b[included] = a[startIdx];
        rec(startIdx + 1, included + 1);
    }
}
