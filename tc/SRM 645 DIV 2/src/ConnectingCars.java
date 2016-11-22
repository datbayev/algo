import java.util.*;

public class ConnectingCars {

    class Pair {
        int begin;
        int end;

        public Pair(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    Comparator<Pair> pairComparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.begin < o2.begin) return -1;
            return 1;
        }
    };

    public long minimizeCost(int[] positions, int[] lengths) {
        int n = positions.length;
        List<Pair> pairs = new ArrayList<Pair>();
        long[] diffs = new long[n];
        long res = 0l;

        for (int i = 0; i < n; i++) {
            int curBegin = positions[i];
            int curEnd = curBegin + lengths[i];
            Pair p = new Pair(curBegin, curEnd);
            pairs.add(p);
        }

        Collections.sort(pairs, pairComparator);

        for (int i = 0; i < n - 1; i++) {
            Pair curPair = pairs.get(i);
            Pair nextPair = pairs.get(i + 1);
            diffs[i] = Math.abs(curPair.end - nextPair.begin);

            int num1 = i + 1;
            int num2 = n - num1;
            if (num1 < num2)
                res += num1 * diffs[i];
            else
                res += num2 * diffs[i];
        }

        return res;
    }
}
