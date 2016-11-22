import java.io.PrintWriter;
import java.util.*;

public class HIndex {
    public int hIndex2(int[] citations) { // using Binary search
        if (citations.length == 0)
            return 0;
        else if (citations.length == 1) {
            if (citations[0] == 0)
                return 0;
            else
                return 1;
        }

        int n = citations.length;

        int l = 1;
        int r = n;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (n - m <= citations[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return n - r;
    }

    public int hIndex(int[] citations) { // O(n) HIndex
        Arrays.sort(citations);

        if (citations.length == 0)
            return 0;
        else if (citations.length == 1) {
            if (citations[0] == 0)
                return 0;
            else
                return 1;
        }

        int res = 1;
        int ind = citations.length - 1;
        while (ind >= 0 && citations[ind] >= res) {
            res++;
            ind--;
        }

        return res - 1;
    }

    public void solve() {
        PrintWriter out = new PrintWriter(System.out);
//        int[] citations = {5, 3, 1, 6, 0};
//        int[] citations = {3, 4, 5, 6, 7, 8, 9};
//        int[] citations = {0};
//        int[] citations = {10};
        int[] citations = {11, 15};
        //int res = hIndex(citations);
        int res = hIndex(citations);
        out.println(res);
        out.close();
    }

    public static void main(String[] args) {
        new HIndex().solve();
    }
}
