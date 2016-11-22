public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        else if (citations.length == 1) {
            if (citations[0] == 0)
                return 0;
            else
                return 1;
        }

        int n = citations.length;
        if (n <= citations[0])
            return n;

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
}
