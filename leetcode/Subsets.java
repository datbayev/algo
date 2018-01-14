package leetcode;

// https://leetcode.com/problems/subsets/description/
// 78. Subsets

import java.util.*;

class Subsets {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> subset = new ArrayList();
            for (int j = 0; j < nums.length; j++)
                if ((i & (1 << j)) > 0)
                    subset.add(nums[j]);

            res.add(subset);
        }

        return res;
    }
}
