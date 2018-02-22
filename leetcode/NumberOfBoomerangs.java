package leetcode;

// https://leetcode.com/problems/number-of-boomerangs/description/
// 447. Number of Boomerangs

import java.util.*;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int n = points.length;

        Map<Integer, Integer> map = new HashMap(); // distance -> count

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;

                int d = dist(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for (int val : map.values())
                res += val * (val - 1);

            map.clear();
        }

        return res;
    }

    private int dist(int[] p1, int[] p2) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return x * x + y * y;
    }
}
