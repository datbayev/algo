import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t > 0) {
            BigInteger n = in.nextBigInteger();

            BigInteger TWO = BigInteger.ONE.add(BigInteger.ONE);
            BigInteger a = BigInteger.ONE;
            BigInteger b = TWO;
            BigInteger c = a.add(b);
            BigInteger sum = TWO;

            while (c.compareTo(n) <= 0) {
                BigInteger mod = c.mod(TWO);
                if (mod.equals(BigInteger.ZERO))
                    sum = sum.add(c);

                a = b;
                b = c;
                c = a.add(b);
            }
            out.println(sum.toString());

            t--;
        }
        out.close();
    }
}
