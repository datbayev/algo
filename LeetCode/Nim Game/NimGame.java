import java.io.PrintWriter;
import java.util.*;

public class NimGame {

    public boolean canWinNim(int n) {
        return n % 4 > 0;
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        boolean res = canWinNim(n);
        out.print(res);
        out.close();
    }

    public static void main(String[] args) {
	    new NimGame().solve();
    }
}
