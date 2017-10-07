import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            long n = in.nextLong();
            long i = 2;

            while (i < (long)Math.sqrt(n) + 1) {
                while (n % i == 0 && i != n)
                    n /= i;
                i++;
            }
            out.println(n);
            t--;
        }
        out.close();
    }
}
