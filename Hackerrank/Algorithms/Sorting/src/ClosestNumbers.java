import java.util.*;
import java.io.*;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++)
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);

        for (int i = 1; i < n; i++)
            if (arr[i] - arr[i - 1] == minDiff)
                out.print(arr[i - 1] + " " + arr[i] + " ");

        out.close();
    }
}
