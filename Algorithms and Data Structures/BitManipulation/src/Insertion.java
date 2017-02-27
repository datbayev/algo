import java.io.PrintWriter;
import java.util.Scanner;

public class Insertion {
    public static void main(String[] args) {
        new Insertion().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();

        int i = in.nextInt();
        int j = in.nextInt();

        for (int k = i; k <= j; k++) {
            boolean curBitIsOne = BitOperations.getBit(m, k - i);
            n = curBitIsOne ? BitOperations.setBit(n, k) : BitOperations.clearBit(n, k);
        }

        out.print(n);
        out.close();
    }
}
