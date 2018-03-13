package leetcode;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// 373. Find K Pairs with Smallest Sums

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;

        if (n == 0 || m == 0)
            return new ArrayList<>();

        List<int[]> res = new ArrayList<>();

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0] + o1[1], o2[0] + o2[1]);
            }
        });

        for (int aNums1 : nums1)
            for (int aNums2 : nums2)
                q.add(new int[]{aNums1, aNums2});

        int cnt = 0;
        while (cnt < k && !q.isEmpty()) {
            res.add(q.poll());
            cnt++;
        }

        return res;
    }
}
