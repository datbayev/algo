import java.io.PrintWriter;
import java.util.*;


public class Solution {

    public static long getSum(long n, int period) {
        while (n % period != 0)
            n--;
        long num = n / period;
        return (period + n) * num / 2;
    }

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        while (t > 0) {
            long n = in.nextInt() - 1;
            long total = getSum(n, 3) + getSum(n, 5) - getSum(n, 15);
            out.println(total);
            t--;
        }

        out.close();
    }
}
