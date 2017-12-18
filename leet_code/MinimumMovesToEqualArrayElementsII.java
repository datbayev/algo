package leet_code;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
// 462. Minimum Moves to Equal Array Elements II

import java.util.Arrays;

class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j = nums.length - 1;
        while (i < j)
            res += nums[j--] - nums[i++];
        
        return res;
    }
}
