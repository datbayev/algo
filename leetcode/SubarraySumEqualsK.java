package leetcode;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
// 560. Subarray Sum Equals K

import java.util.*;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0, n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] sums = new int[n];
        sums[0] = nums[0];

        for (int i = 1; i < n; i++)
            sums[i] = sums[i - 1] + nums[i];

        for (int i = 0; i < n; i++) {
            int s = sums[i];

            if (!map.containsKey(s))
                map.put(s, new ArrayList<>());

            map.get(s).add(i);
        }

        for (int i = 0; i < n; i++) {
            int cur = sums[i];

            if (cur == k)
                res++;

            List<Integer> list = map.getOrDefault(cur + k, null);
            if (list == null)
                continue;

            for (int pos : list)
                if (pos > i)
                    res++;
        }

        return res;
    }
}
