package leetcode;

// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
// 325. Maximum Size Subarray Sum Equals k

import java.util.*;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k))
                max = Math.max(max, i - map.get(sum - k));

            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return max;
    }

    public int maxSubArrayLenBruteForce(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int max = Integer.MIN_VALUE;

        int[] sums = new int[n];
        sums[0] = nums[0];
        if (sums[0] == k)
            max = 1;

        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
            if (sums[i] == k)
                max = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++)
                if (sums[j] - sums[i] == k)
                    max = Math.max(max, j - i);
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
