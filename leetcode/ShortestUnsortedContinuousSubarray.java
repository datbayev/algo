package leetcode;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
// 581. Shortest Unsorted Continuous Subarray

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2)
            return 0;

        int[] init = nums.clone();
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1, n = nums.length;

        while (i < n && init[i] == nums[i])
            i++;

        while (j >= 0 && init[j] == nums[j])
            j--;

        if (i > j)
            return 0;

        return j - i + 1;
    }
}
