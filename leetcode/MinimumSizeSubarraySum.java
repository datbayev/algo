package leetcode;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
// 209. Minimum Size Subarray Sum

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;

        int i = 0, j = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
