import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int t = in.nextInt();

        int num = 0;
        int x = t;
        while (x > 0) {
            x /= 10;
            num++;
        }

        if (num > n) {
            out.print(-1);
        } else {
            out.print(t);
            for (int i = 0; i < n - num; i++)
                out.print(0);
        }

        out.close();
    }
}
