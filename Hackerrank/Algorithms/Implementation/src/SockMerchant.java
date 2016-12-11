import java.util.*;
import java.io.*;

public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int res = 0;
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (set.contains(x)) {
                set.remove(x);
                res++;
            } else
                set.add(x);
        }

        out.print(res);
        out.close();
    }
}
