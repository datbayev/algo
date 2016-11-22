import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int l = in.nextInt();

        int p = in.nextInt();
        int q = in.nextInt();

        double time;
        q += p;
        time = 1.0 * l / q;

        double res = time * p;
        out.print(String.format("%.4f", res));
        out.close();
    }
}
