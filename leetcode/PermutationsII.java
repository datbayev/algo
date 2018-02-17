package leetcode;

// https://leetcode.com/problems/permutations-ii/description/
// 47. Permutations II

import java.util.*;

public class PermutationsII {
    List<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        used = new boolean[nums.length];

        rec(0, nums, new ArrayList<>());

        return res;
    }

    public void rec(int x, int[] nums, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && (i == 0 || nums[i] != nums[i - 1])) {
                used[i] = true;
                cur.add(nums[i]);

                rec(i + 1, nums, cur);

                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}
