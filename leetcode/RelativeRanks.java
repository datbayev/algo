package leetcode;

// https://leetcode.com/problems/relative-ranks/description/
// 506. Relative Ranks

import java.util.*;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length; // positive
        String[] res = new String[n];
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++)
            map.put(sorted[i], i);

        for (int i = 0; i < n; i++) {
            int pos = map.get(nums[i]);

            if (nums[i] == sorted[n - 1])
                res[i] = "Gold Medal";
            else if (n > 1 && nums[i] == sorted[n - 2])
                res[i] = "Silver Medal";
            else if (n > 2 && nums[i] == sorted[n - 3])
                res[i] = "Bronze Medal";
            else
                res[i] = String.valueOf(n - pos);
        }

        return res;
    }
}
