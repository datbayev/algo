import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        long k = in.nextLong();

        out.print(numberOfPairs(a, k));

        out.close();
    }

    static int numberOfPairs(int[] a, long k) {
        int n = a.length;

        if (n < 2)
            return 0;

        int res = 0;
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put((long)a[i], 1);

        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - a[i]))
                res++;
        }

        return res / 2;
    }
}
