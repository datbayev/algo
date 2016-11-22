import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int max = 0;
        int cur = 0;
        int last = 0;

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x >= last) {
                cur++;
            } else {
                if (max < cur)
                    max = cur;
                cur = 1;
            }

            last = x;
        }
        if (max < cur)
            max = cur;

        out.println(max);

        out.close();
    }
}
