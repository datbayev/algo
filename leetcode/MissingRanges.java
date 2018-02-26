package leetcode;

// https://leetcode.com/problems/missing-ranges/description/
// 163. Missing Ranges

import java.util.*;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            addRange((long)lower, (long)upper, res, true);
            return res;
        }

        long first = (long)nums[0];
        long last = (long)nums[nums.length - 1];

        if (first != lower) {
            long longLower = (long)(lower) - 1;
            addRange(longLower, first, res, false);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            long cur = (long)nums[i];
            long next = (long)nums[i + 1];

            addRange(cur, next, res, false);
        }

        if (last != upper)
            addRange(nums[nums.length - 1], (long)(upper) + 1, res, false);

        return res;
    }

    private void addRange(long left, long right, List<String> res, boolean inclusive) {
        if (inclusive) {
            left--;
            right++;
        }

        if (right - left < 2)
            return;
        else if (right - left == 2)
            res.add(String.valueOf(left + 1));
        else
            res.add(String.format("%d->%d", left + 1, right - 1));
    }
}
