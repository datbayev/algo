import java.util.*;
import java.io.*;

public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = 5;
        long sum = 0;

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long cur = in.nextInt();
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            sum += cur;
        }

        out.print((sum - max) + " " + (sum - min));
        out.close();
    }
}
