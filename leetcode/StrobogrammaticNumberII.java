package leetcode;

// https://leetcode.com/problems/strobogrammatic-number-ii/description/
// 247. Strobogrammatic Number II

import java.util.*;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        if (n == 2)
            return Arrays.asList("11","69","88","96");

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, Collections.singletonList(""));
        map.put(1, Arrays.asList("1", "8", "0"));

        calc(n, n, map);

        return map.get(n);
    }

    private void calc(int cur, int n, Map<Integer, List<String>> map) {
        if (map.containsKey(cur))
            return;

        calc(cur - 2, n, map);

        List<String> list = map.get(cur - 2);
        List<String> nlist = new ArrayList<>();

        for (String s : list) {
            nlist.add("1" + s + "1");
            nlist.add("8" + s + "8");
            nlist.add("6" + s + "9");
            nlist.add("9" + s + "6");

            if (cur < n)
                nlist.add("0" + s + "0");
        }

        map.put(cur, nlist);
    }
}
