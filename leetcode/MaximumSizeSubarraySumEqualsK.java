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
}
