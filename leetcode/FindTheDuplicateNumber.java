package leetcode;

// https://leetcode.com/problems/find-the-duplicate-number/description/
// 287. Find the Duplicate Number

import java.util.Arrays;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1]) {
                res = nums[i];
                break;
            }

        return res;
    }
}
