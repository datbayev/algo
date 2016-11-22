import java.io.PrintWriter;
import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] a) {
        int n = a.length;

        if (n == 0)
            return 0;

        int[] d = new int[n];
        int[] p = new int[n];
        List<Integer> path = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {

            d[i] = 1; // the number itself with length '1'
            p[i] = -1; // path with length 1 ends at element itself

            for (int j = 0; j < i; j++) { // go backwards
                if (a[j] < a[i])
                    if (d[i] < d[j] + 1) { // if a[j] --> a[i] is optimal, then update result
                        d[i] = d[j] + 1;
                        p[i] = j; // we come to i-th from j-th
                    }
            }
        }

        int maxLen = d[0];
        int position = 0;

        for (int i = 0; i < n; i++)
            if (maxLen < d[i]) {
                maxLen = d[i];
                position = i;
            }

        while (position != -1) { // recovering the path backwards
            path.add(p[position]);
            position = p[position];
        }

        return path.size();
    }
}