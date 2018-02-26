package leetcode;

// https://leetcode.com/problems/two-sum/description/
// 1. Two Sum

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(x)) {
                res[0] = i;
                res[1] = map.get(x);
                break;
            }

            map.put(target - x, i);
        }

        return res;
    }
}
