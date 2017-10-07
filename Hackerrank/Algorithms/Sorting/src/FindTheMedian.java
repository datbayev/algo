import java.util.*;
import java.io.*;

public class FindTheMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] count = new int[20001];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            count[arr[i] + 10001]++;
        }

        int c = 0;
        for (int i = 0; i <= 20000; i++) {
            if (count[i] > 0)
                c += count[i];
            if (c > (n - 1) / 2) {
                out.print(i - 10001);
                break;
            }
        }

        out.close();
    }
}
