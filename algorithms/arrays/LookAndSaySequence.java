package algorithms.arrays;

import java.util.*;

public class LookAndSaySequence {
    public static List<List<Integer>> getLookAndSaySequence(int n) {
        if (n == 0)
            return new ArrayList<>();

        assert n >= 0;

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 0; i < n - 1; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> list = res.get(res.size() - 1);
            int m = list.size(), j = 0;

            while (j < m) {
                int k = j + 1;
                while (k < m && list.get(j) == list.get(k))
                    k++;

                cur.add(k - j);
                cur.add(list.get(j));

                j = k;
            }

            res.add(cur);
        }

        return res;
    }
}
